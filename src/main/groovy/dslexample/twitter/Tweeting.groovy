package dslexample.twitter

import twitter4j.*
import twitter4j.conf.ConfigurationBuilder;

ConfigurationBuilder cb = new ConfigurationBuilder();
cb.setDebugEnabled(true)
  .setOAuthConsumerKey("yZi3GKpxLfmPHM9wKncog")
  .setOAuthConsumerSecret("hZbHxZZhcargMpzSWZ0ABH13q5aXxkCKOqFpTuCiZjg")
  .setOAuthAccessToken("132940691-zJOy9elOv0McixMpuY8zttu4o99BggGb3f2EplL5")
  .setOAuthAccessTokenSecret("PWmjpDSEoHWI7Sw6TofuIjn0yaRhVaxzZSpJrnSX8zxL1");

Twitter twitter = new TwitterFactory(cb.build()).getInstance();

// Update Status
//Status status =twitter.updateStatus("Updating my status via the Twitter4J APIs")
//System.out.println("Successfully updated the status to [" + status.getText() + "].");

//Direct message
def messages = twitter.directMessages

messages.each{message ->
	println "Message from: $message.senderScreenName" 
	println " ${message.text}"
}
println "================= Query =================="
//Searching
def query = new Query("PAL")
println twitter.search(query).toString()

twitter.search(query).tweets.each{tweet ->
	println "${tweet.user.name} : ${tweet.text}\n"
}
println "=============== Get a list of my followers================"

twitter.friendsFollowers().each{
	println it.screenName
}

println "=============== Get a list of my favorite================"
twitter.favorites.each{
	println it
}

twitter.


