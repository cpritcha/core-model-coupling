from core_model_coupling cimport example_get_origin, core_init

def example_get_origin_c():
    return example_get_origin()

def core_init_c():
    core_init()