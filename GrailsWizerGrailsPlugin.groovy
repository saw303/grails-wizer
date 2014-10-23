import org.subethamail.wiser.Wiser

class GrailsWizerGrailsPlugin {
    // the plugin version
    def version = "0.2"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.4 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Grails Wizer Plugin" // Headline display name of the plugin
    def author = "Silvio Wangler"
    def authorEmail = "silvio.wangler@gmail.com"
    def description = '''\
Uses wizer as SMTP server in order to test email sending in integration tests.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/grails-wizer"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
    def developers = [ [ name: "Silvio Wangler", email: "silvio.wangler@gmail.com" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GitHub", url: "https://github.com/saw303/grails-wizer/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/saw303/grails-wizer" ]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        wiser(Wiser) { bean ->
            bean.initMethod = 'start'
            bean.destroyMethod = 'stop'
            port = 25000
            hostname = 'localhost'
        }
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { ctx ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
