# [CS111B] 2017.07.11

### Callbacks

* **callback** - any executable code that is passed as an argument to other code, which is expected to call back (execute) the argument at a given time
* this execution may be immediate as in a **synchronous callback**, or it might happen at a later time as in an **asynchronous callback**
* Abbas: methods that are not called directly by programmers

### Running Web Server on `hills`

* ssh into hills: `ssh rramphal@hills.ccsf.edu`
* run bash command `setup` (this will generate `public_html`)
* move files into `public_html`
* `chmod 755` any files that you want to make public
* go to `http://hills.ccsf.edu/~rramphal/`

### Web Server

* a computer running software that runs a web server
* Apache

### Applets

* may be installed on Apache and accessed from all around the world
* you can also pass an HTML Applet URL into `appletViewer`

* hierarchy of Applets: Component (hundreds of abstract classes) > Container (implements some of those classes) > Panel > Applet

* [see DemoApplet.java]

* you cannot create a for loop to animate because it will break connection with applet and then will drop the applet
