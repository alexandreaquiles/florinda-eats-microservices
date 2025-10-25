docker exec -it kafka /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic pagamentosConfirmados
# Created topic pagamentosConfirmados.

docker exec -it kafka /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
# __consumer_offsets
# pagamentosConfirmados

docker exec -it kafka /opt/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic pagamentosConfirmados
# Topic: pagamentosConfirmados	TopicId: IRuQelnHRDOb9f4ur_rVrA	PartitionCount: 3	ReplicationFactor: 1	Configs: 
# 	Topic: pagamentosConfirmados	Partition: 0	Leader: 1	Replicas: 1	Isr: 1	Elr: 	LastKnownElr: 
# 	Topic: pagamentosConfirmados	Partition: 1	Leader: 1	Replicas: 1	Isr: 1	Elr: 	LastKnownElr: 
# 	Topic: pagamentosConfirmados	Partition: 2	Leader: 1	Replicas: 1	Isr: 1	Elr: 	LastKnownElr: 

docker exec -it kafka /opt/kafka/bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic pagamentosConfirmados
# >{"pagamentoId": 1, "pedidoId": 1}
# >{"pagamentoId":2,"pedidoId":2}
# >

docker exec -it kafka /opt/kafka/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic pagamentosConfirmados --from-beginning
# {"pagamentoId": 1, "pedidoId": 1}
# {"pagamentoId":2,"pedidoId":2}

docker exec -it kafka /opt/kafka/bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --all-groups --describe 
# Consumer group 'console-consumer-621' has no active members.













