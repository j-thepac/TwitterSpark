/*
Twitter event Streaming
generete keys here : https://apps.twitter.com/
note : Reset password to add keys ie ., Twitter > more > Account Setting > Reset Password

Consumer Key (API Key)
Consumer Secret (API Secret)
Access Token
Access Token Secret

Optional - Filter Key - if we need to filter any specified subject in Twitter.
 */

import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import twitter4j.conf.ConfigurationBuilder
import twitter4j.auth.OAuthAuthorization
import org.apache.spark.streaming.twitter.TwitterUtils

object twitterstreaming {
  def main(args: Array[String]) {

    val conf = new SparkConf()
      .setAppName("TwitterData")
      .setMaster("local[2]")
    val ssc = new StreamingContext(conf, Seconds(5))
    val cb = new ConfigurationBuilder

    //credentials from :https://apps.twitter.com/
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey("xxx") //apikey
      .setOAuthConsumerSecret("xxx") //api secret
      .setOAuthAccessToken("xxx")
      .setOAuthAccessTokenSecret("xxx")

    val auth = new OAuthAuthorization(cb.build)
    val tweets = TwitterUtils.createStream(ssc, Some(auth))

    tweets.saveAsTextFiles("tweets", "json")
    ssc.start()
    ssc.awaitTermination()
  }
}
