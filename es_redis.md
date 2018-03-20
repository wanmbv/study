## ES优化
+ JVM内存设置不要超过机器的一半内存，并且不超过32G。（./bin/elasticsearch -Xmx10g -Xms10g或者修改./bin/elasticsearch.in.sh文件
+ 设置每个线程的堆栈大小, ES单线程承载的数据量比较大，JAVA_OPTS="$JAVA_OPTS -Xss128m"
+ 修改swapping参数，内存不够用时才进行swapping（vm.swappiness= 1）
+ 锁定内存，不让JVM写入swapping，避免降低ES的性能，bootstrap.mlockall: true
+ 缓存类型设置为Soft Reference，只有当内存不够时才会进行回收：
    index.cache.field.max_size: 50000 
    index.cache.field.expire: 10m 
    index.cache.field.type: soft
+ 如果不使用_all字段最好关闭这个属性。
+ 避免返回大量结果集的搜索与聚合。缺失需要大量拉取数据可以采用scan & scroll api来实现。
+ linux操作系统需要修改max open files，修改/etc/security/limits.conf。
+ 主副本不要在一台物理机上。
+ 根据需要调整index.refresh_interval参数，默认是1秒，频繁写操作时，调大参数，增加吞吐量。
+ 修改垃圾回收器为G1，默认为CMS，bin/elasticsearch.in.sh文件中：
    JAVA_OPTS=”$JAVA_OPTS -XX:+UseG1GC”
    JAVA_OPTS=”$JAVA_OPTS -XX:MaxGCPauseMillis=200″
## redis优化
+ redis.conf修改maxmemory，根据设计指定最大内存大小，不要无限占用内存，最大内存不要超过实际内存的3/5。
+ vm-enabled设置为no。
+ redis.conf修改maxclients，最大访问客户端。
+ linux操作系统需要修改max open files，修改/etc/security/limits.conf。
+ slowlog-log-slower-than 1000000，记录超过1秒的操作。
+ daemonize yes，设置成守护进程。
+ 只是用redis做缓存时，关闭持久化，redis.conf中：
    save 900 1  
    save 300 10  
    save 60 10000  
