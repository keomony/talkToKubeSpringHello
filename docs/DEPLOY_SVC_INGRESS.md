Service selects a pod which it forwards the traffic to.
Ingress selects a service which it forwards the traffic to.
When one deployment has multiple pods, service will select one of the pods to forward the traffic to.
in service.yml
```agsl
spec:
  selector:
    app: talk-to-kube-spring-hello
  ports:
    - protocol: TCP
      port: 80
      targetPort: 9090
```

Service will select one of the pods which has label app: `talk-to-kube-spring-hello` and that pod has port:9090 to forward the traffic to.
`port: 80` is the port of the service. This is the port of the service that it exposes to the outside world.
`port:9090` is the port of the pod/container. This is the port of the pod that it exposes to the service.

When one deployment wants to talk to another, the deployment needs to talk to another by a service name.

in deploy.yml
```agsl
          env:
            - name: API_URL
              value: "http://my-service-kube-spring-hello.default"
```
`my-service-kube-spring-hello` is the service name of the service that we want to talk to.
`default` is the namespace of the service that we want to talk to.
`80` is the port of the service that we want to talk to.

Note: This happens only when those deployments are in the same cluster.
