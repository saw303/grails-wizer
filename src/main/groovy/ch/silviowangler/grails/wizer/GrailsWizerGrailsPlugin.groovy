package ch.silviowangler.grails.wizer

import grails.plugins.Plugin
import org.subethamail.wiser.Wiser

class GrailsWizerGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    // TODO Fill in these fields
    def title = "Grails Wizer" // Headline display name of the plugin
    def author = "Silvio Wangler"
    def authorEmail = "silvio.wangler@gmail.com "
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
    def developers = [[name: "Silvio Wangler", email: "silvio.wangler@gmail.com"]]

    // Location of the plugin's issue tracker.
    def issueManagement = [system: "GitHub", url: "https://github.com/saw303/grails-wizer/issues"]

    // Online location of the plugin's browseable source code.
    def scm = [url: "https://github.com/saw303/grails-wizer"]

    Closure doWithSpring() {
        { ->
            wiser(Wiser) { bean ->
                bean.initMethod = 'start'
                bean.destroyMethod = 'stop'
                port = 25000
                hostname = 'localhost'
            }
        }
    }
}
