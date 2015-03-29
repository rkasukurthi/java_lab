package dslexample.twitter

import twitter4j.*
import twitter4j.conf.ConfigurationBuilder;


class GeeTwitter {
	static Twitter twitter=null;
	static {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("yZi3GKpxLfmPHM9wKncog")
				.setOAuthConsumerSecret("hZbHxZZhcargMpzSWZ0ABH13q5aXxkCKOqFpTuCiZjg")
				.setOAuthAccessToken("132940691-zJOy9elOv0McixMpuY8zttu4o99BggGb3f2EplL5")
				.setOAuthAccessTokenSecret("PWmjpDSEoHWI7Sw6TofuIjn0yaRhVaxzZSpJrnSX8zxL1");
		twitter = new TwitterFactory(cb.build()).getInstance();
	}

	static void search(terms, Closure c) {
		def query = new Query(terms)
		twitter.search(query).tweets.each{
			c.call(it.user.name, it.text)
		}
	}
}

GeeTwitter.search('PAL'){from , tweet -> println "${from} : ${tweet}"}