use std::vec::Vec;

trait Port<Element> {
    fn add(el: Element);
    fn clear();
}

trait Simulator {
    fn run();
}

trait AtomicModel {
    fn confluent_transition();
    fn external_transition();
    fn internal_transition();
    fn ouput();
    fn time_advance();
}

trait CoupledModel {
    
}

trait AtomicSimulator : Simulator {
    fn compute_input_output();
    fn next_event_time();
    fn transition();
}

trait CoupledSimulator : Simulator {
    fn compute_input_output();
    fn next_event_time();
    fn send_messages();
    fn transition();
}