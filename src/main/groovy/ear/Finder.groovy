package ear;

def zipFile = new java.util.zip.ZipFile(new File('C:/TEMP/ApproveItWebServer_JBoss.ear'))
zipFile.entries().each {
println zipFile.getInputStream(it).text
}