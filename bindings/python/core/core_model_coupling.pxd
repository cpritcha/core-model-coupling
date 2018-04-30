cdef extern from 'core_model_coupling.h':
    ctypedef struct Point:
        float x
        float y
    Point example_get_origin();
    void core_init();