package example.dynamic_groovy


//*************************** Example one ***********************
class XmlBuilder {
   def out
   XmlBuilder(out) { this.out = out }
   def invokeMethod(String name, args) {
       out << "<$name>"
       if(args[0] instanceof Closure) {
            args[0].delegate = this
            args[0].call()
       }
       else {
           out << args[0].toString()
       }
       out << "</$name>"
   }
}

def xml = new XmlBuilder(new StringBuffer())
xml.html {
    head {
        title "Hello World"
    }
    body {
        p "Welcome!"
    }
}

println xml.out
