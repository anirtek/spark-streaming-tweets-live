# spark-streaming-tweets-live

This is my experiment while learning spark streaming.
Functionalities realized:
- Reading book lines and counting distinct words
- Saving live tweets locally into checkpointing directory
- Finding the most trending hashtags 
- Using DStreams and RDDs for more generalized understanding of data 
- Finding average length of the tweet(s)

Live Twitter data is also consumed with a batch that runs at
every 1 second of duration. You need following 3 jar files to
achiver this - 
1. twitter-4j-core
2. twitter-4j-streaming
3. dstream-twitter

Also since this is a Spark Streaming application, you will have
to install the spark first and either copy or specify the location
of all the spark jars from the installtion directory.

File twitter.txt contains the pairs of access key and public key
so as to successfully use the twitter api(s) for the live 
ingestion of the data into spark transformation engine.

