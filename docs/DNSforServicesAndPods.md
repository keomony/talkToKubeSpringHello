
For example, consider a Pod in a `test` namespace. A `data` Service is in the `prod` namespace.

a Pod in a `test` namespace wants to access to a Service in the `prod` namespace.

A query for `data` returns no results, because it uses the Pod's `test` namespace.

A query for `data.prod` returns the intended result, because it specifies the namespace.

 [Click here](https://kubernetes.io/docs/concepts/services-networking/dns-pod-service/)  
 [how two k8s services talk to each other](https://stackoverflow.com/questions/45720084/how-to-make-two-kubernetes-services-talk-to-each-other)