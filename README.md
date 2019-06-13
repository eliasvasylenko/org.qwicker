# Wicka

For the resolution and deployment of ES6 modules in the JVM.

There are a few ways to achieve this, with different tradeoffs. There are some important observations which are common to all methods.

- It is possible to embed versions which follow the semver specification in OSGi versions.

## Wrap ES6 Modules in Bundles

CommonJS repositories (e.g. NPM) can be wrapped as OSGi repositories which automatically materialize resolved ES6 modules as OSGi bundles. Pertinent information from the `package.json` is reflected through the appropriate manifest headers

### At Build Time

We need our ES6 artifacts to be available at build time only, and they are wrapped as bundles and redeployed by our build process.

This is trivial within Bnd as we can just add a respository plugin to the build configuration, but is trickier with e.g. Maven as we need some way to republish in a Maven repository. It may be possible for a Maven plugin to be designed which is able to resolve a Bnd repository and republish the artifacts in Maven local, which would be a solution for this.

At run time we don't need to take any special measures, so far as the platform is concerned everything is provided as bundles.

### At Run Time

We want our ES6 artifacts to be made-available at run time, either in a private 

Because the framework checks that all our requirements are fulfilled when our bundles are started, in order for other bundles to depend on those materialized through our repository implementation they need to be installed at launch, which means we need a special launcher implementation which is aware of statically configured OSGi repositories.

## Wrap ES6 Modules in Connect Bundles

As per https://github.com/osgi/design/blob/master/rfps/rfp-0196-OSGiConnect.pdf

- Can be loaded directly from the filesystem (or anywhere else via classloader), no need for Jar bundling.
- Again may need a special launcher which is aware of how to install them.
- How do we resolve them at deploy them at build time? May need special build tooling.

### Use Features to Describe Connect Bundles

As per https://github.com/osgi/design/blob/master/rfcs/rfc0241/rfc-0241-Features.pdf

With respect to the build-time resolution problem above. Our build tooling now just needs to generate a feature which forwards the appropriate capabilities, which can then be bundled as part of the application.
