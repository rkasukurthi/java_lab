package example.ExpandoMetaClass

//Given the Java class java.lang.String to obtain its ExpandoMetaClass you can use:
//every java.lang.Class is supplied with a special "metaClass" property that when used will give you a reference to an ExpandoMetaClass instance

String.metaClass.swapCase = {->
      def sb = new StringBuffer()
	  //closure has a delegate
      delegate.each {
           sb << (Character.isUpperCase(it as char) ? Character.toLowerCase(it as char) : 
                   Character.toUpperCase(it as char))
      }
      sb.toString()
}

println "dddddddddd".swapCase()