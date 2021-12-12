1、A节点和B节点都是三个配置，然后分别起来三个redis实例端口
./redis-server redis_7000.conf
./redis-server redis_7001.conf
./redis-server redis_7002.conf
2、节点meet
./redis-cli -p 7000 cluster meet 127.0.0.1 7001
./redis-cli -p 7000 cluster meet 127.0.0.1 7002
./redis-cli -p 7000 cluster meet 192.168.249.116 7000
./redis-cli -p 7000 cluster meet 192.168.249.116 7001
./redis-cli -p 7000 cluster meet 192.168.249.116 7002
3、主节点槽位分发
redis-cli -p 6379 cluster addslots {0..5461}
redis-cli -p 6380 cluster addslots {5462..10922}
redis-cli -p 6381 cluster addslots {10923..16383}
4、使用cluster replicate 添加从节点在从节点上执行
redis-cli -p 7000
cluster replicate 主节点7000ID
redis-cli -p 7001
cluster replicate 主节点7001ID
redis-cli -p 7002
cluster replicate 主节点7002ID


