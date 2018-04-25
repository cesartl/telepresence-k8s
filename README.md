# telepresence-k8s
Sample project to show integration between telepresence and the Java Kubernetes Client from fabric8

# Requirements
You need a running K8s cluster and install [telepresence](https://www.telepresence.io/) locally

# Demo

### Setting up Quote Of the Moment Service
`kubectl run qotm --image=datawire/qotm:1.3 --port=5000 --expose`

### Basic profile

Using the basic profile, service disovery using K8S API is disable; The Ribbon client use the service host name directly:

```yaml
qotm:
    ribbon:
        listOfServers: qotm:5000
```

You can run the service with telepresence by running

`./telepresence-basic.sh`

Once sprince has started, you can make a GET request locally:

`curl localhost:8080/rest/quote/cesar`

```
A quote for cesar: Nihilism gambles with lives, happiness, and even destiny itself!% 
```
### Discovery profile

Using the discovery profile, Ribbon will use `io.fabric8.kubeflix.ribbon.KubernetesServerList` to discover the list of server:

```yaml
qotm:
  ribbon:
    NIWSServerListClassName: io.fabric8.kubeflix.ribbon.KubernetesServerList
    KubernetesNamespace: ${K8S_NAMESPACE:default}
```


You can run the service with telepresence by running

`./telepresence-discovery.sh`

This command uses the `--mount` command available from Telepresence `0.85` to access the k8s service account
