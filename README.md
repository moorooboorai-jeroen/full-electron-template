# full-electron

[![Clojars Project](https://img.shields.io/clojars/v/full-electron/lein-template.svg)](https://clojars.org/full-electron/lein-template)

# Status

This is very much work-in progress. Pushed since I was way to eager to proceed and share amongst friendly people.
Usage for now is largely undocumented, untested and therefore completely at your own risk.

# Usage

When you want to use a properly released version, use

```sh
$ lein new full-electron my-electron
```

Otherwise, when feeling adventurous and bleeding cutting edge then use

```sh
$ lein new full-electron my-electron --snapshot
```

Very convenient.
Finally, to confuse you, you should actually really use the snapshot while the WIP flag is being raised. Just sayin'.


# Development

Getting a local copy of the template to play, errr...develop with:

```sh
$ lein jar && lein install
```

## TODO
Add support for additional popular Electron/NPM modules:

- [menubar](https://github.com/maxogden/menubar)

## License

Copyright © 2016 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
