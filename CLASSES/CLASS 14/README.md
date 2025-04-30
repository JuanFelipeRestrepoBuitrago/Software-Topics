# Commands Used
1. Docker Swarm Initialization
```bash
docker swarm init --advertise-addr 172.29.188.13
```
2. Create a Docker Network with 4 replicas
```bash
docker service create --name randomquotes --replicas 4 -p 8080:8080 piper04/eafit-teis-tutorial-16-randomquotes
```
3. Remove service
```bash
docker service rm randomquotes
```
4. Create a Docker Network with 4 replicas and 2 replicas in each node
```bash
docker service create --name randomquotes --replicas 4 -p 8080:8080 piper04/eafit-teis-tutorial-16-randomquotes:v1.0.1
```

# Commands in AWS
1. Docker Swarm Initialization
```bash
docker swarm init
```
2. Create a Docker Network with 4 replicas
```bash
docker service create --name randomquotes --replicas 4 -p 80:8080 piper04/eafit-teis-tutorial-16-randomquotes:v1.0.1
```

3.. Connect the other instances to the swarm
```bash
docker swarm join --token SWMTKN-1-4ln9hynvoc0igamdpbhb89ph5zlt7hfd5aqit4zbdksa8u1275-23lmvf4hspnb112hteg2xwpy4 172.31.88.36:2377
```