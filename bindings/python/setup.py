from setuptools import setup, Extension
from Cython.Build import cythonize
from Cython.Distutils import build_ext
from invoke import task, Context
import os

@task
def build_rust(ctx):
    with ctx.cd('../..'):
        ctx.run('cargo build --release')

build_rust(Context())

ext = Extension('core.binding',
                ['core/binding.pyx', 'core_model_coupling.pxd'],
                library_dirs=['../../target/release'],
                libraries=['core_model_coupling'],
                runtime_library_dirs=['../../target/release'],
                # extra_objects=['../../target/release/libcore_model_coupling.a'],
                include_dirs=['../../target', '.'])

extensions = [ext]

setup(
    name='core',
    version='0.0.1',
    packages=['core'],
    zip_safe=False,
    platforms='any',
    ext_modules=cythonize(extensions),
    cmdclass={'build_ext': build_ext}
)
