# {{name}} - building {{appname}} for OS X and Windows

A seriously ambitious Electron app.

# Initial steps

Install [Electron](http://electron.atom.io/) via [electron-prebuilt](https://www.npmjs.com/package/electron-prebuilt)
and [nw-dev](https://www.npmjs.com/package/nw-dev) dependencies, like so:

```sh
$ npm install
```

Be patient if this is your first time.

# Optional steps

Replace icons.


# Live Coding
Coming from a ClojureScript, Figwheel enabled development pipeline, I'm always graving for a well established
live coding experience.



# Distribution


## Toolset
Install both [electron-packager](https://github.com/maxogden/electron-packager) and [electron-builder](https://www.npmjs.com/package/electron-builder).

When on OS X, do yourself a big fave' and prepare your machine for building Windows installers also.
There are [specific installation instructions listed](https://www.npmjs.com/package/electron-builder#pre-requisites)
 on how to achieve that with Homebrew.

## Packaging
Packages allow you, the developer, to run what most closely resembles the application in production shape.

Install `electron-packager` beforehand.


Package for OS X, mind the version number, use `electron -v` to get yours.
Although you can build for other versions besides the one you've got installed.


Building for OS X

```sh
$ electron-packager . {{appname}} --out dist/pkg/darwin --platform=darwin --arch=x64 --version=$(electron -v | cut -c2-)
```

Building for Windows (whilst on OS X)

```sh
$ electron-packager . {{appname}} --out dist/pkg/win32 --platform=win32 --arch=x64 --version=$(electron -v | cut -c2-)
```

Building for Linux

```sh
$ electron-packager . {{appname}} --out dist/pkg/linux --platform=linux --arch=x64 --version=$(electron -v | cut -c2-)
```


## Building Installers
Installers allow end users to install the application with a minimum of effort.
Packages need to have been build beforehand.

```sh
$ electron-builder dist/pkg/darwin/{{appname}}-darwin-x64/someFancyApp.app/ --platform=osx --out=dist/installer/darwin --config=build-config.json
```

```sh
$ electron-builder dist/pkg/win32/{{appname}}-win32-x64/ --platform=win --out=dist/installer/win32 --config=build-config.json
```

# Untested shizzle

```sh
gem install foreman              # install foreman gem (see Procfile)
npm install electron-prebuilt -g # install electrob binaries

foreman start &                  # compile cljs and start figwheel
electron .                       # start electron
```


