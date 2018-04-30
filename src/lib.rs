#[macro_use]
extern crate chan;
extern crate chan_signal;

extern crate hyper;
extern crate futures;

mod server;

use std::thread;

use chan_signal::Signal;

use hyper::server::Http;
use server::Actor;

#[repr(C)]
pub struct Point {
    pub x: f32,
    pub y: f32,
}

#[no_mangle]
pub unsafe extern "C" fn example_get_origin() -> Point {
    Point { x: 0.0, y: 0.0 }
}

fn run(_sdone: chan::Sender<()>) {
    let addr = "127.0.0.1:3000".parse().unwrap();
    let server = Http::new().bind(&addr, || Ok(Actor)).unwrap();
    server.run().unwrap()
}

#[no_mangle]
pub unsafe extern "C" fn core_init() {
    let signal = chan_signal::notify(&[Signal::INT, Signal::TERM]);
    let (sdone, rdone) = chan::sync(0);

    thread::spawn(move || {
        run(sdone);
    });

    chan_select! {
        signal.recv() -> _signal => {
            println!("Recieved Stop Notification. Shutting Down Web Server")
        },
        rdone.recv() => {
            println!("Webserver Stopped.")
        }
    }
}