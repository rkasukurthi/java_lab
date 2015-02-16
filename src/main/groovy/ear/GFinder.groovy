package ear;

def zipFile = new java.util.zip.ZipFile(new File('C:/TEMP/eSL-Core-Legacy.ear'))
zipFile.entries().each {
println zipFile.getInputStream(it).text
}