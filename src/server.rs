use futures::future::Future;
use hyper::header::ContentLength;
use hyper::server::{Request, Response, Service};
use hyper;
use futures;

pub struct Actor;

const PHRASE: &'static str = "Hello, World!";

impl Service for Actor {
    type Request = Request;
    type Response = Response;
    type Error = hyper::Error;

    type Future = Box<Future<Item=Self::Response, Error=Self::Error>>;

    fn call(&self, _req: Request) -> Self::Future {
        Box::new(futures::future::ok(
            Response::new()
                .with_header(ContentLength(PHRASE.len() as u64))
                .with_body(PHRASE)
        ))
    }
}