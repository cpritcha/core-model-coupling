from setuptools import setup

def build_native(spec):
    # build an example rust library
    build = spec.add_external_build(
        cmd=['cargo', 'build', '--release'],
        path='../..'
    )

    spec.add_cffi_module(
        module_path='core_model_coupling._native',
        dylib=lambda: build.find_dylib('core_model_coupling', in_path='target/release'),
        header_filename=lambda: build.find_header('core_model_coupling.h', in_path='target'),
        rtld_flags=['NOW', 'NODELETE']
    )

setup(
    name='core_model_coupling',
    version='0.0.1',
    packages=['core_model_coupling'],
    zip_safe=False,
    platforms='any',
    setup_requires=['milksnake'],
    install_requires=['milksnake'],
    milksnake_tasks=[
        build_native
    ]
)