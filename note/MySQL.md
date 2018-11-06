# MySQL

## Principle
1. Before the transaction finishing updating, master record changes into a Binary log serially.
2. When event finish writing into the Binary log, master tell the store engine to hand in transaction.
3. Slave open a I/O thread and connect to the master.
4. Slave begin a BLog down process to copy the binary log using a queue.
5. Slave write the log into the Relay log.
6. Slave repeat the events in the Relay log in a SQL thread.
## Configuration of Master and Slave
1. Config Master
- Open the Binary log
``` bash
vim /etc/my.cnf
[mysqld]
server-id=1
log-bin=master-bin
log-bin-index=master-bin.index
```
- restart mySQL service
``` bash
service mysqld restart
```
- validate 
``` bash
mysql > SHOW MASTER STATUS;
```
- Create User
```bash
mysql> create user <user name>
```
- Authenticate
    - give the slave at host right to replicate on all database and all tables
```bash
mysql> GRANT REPLICATION SLAVE ON *.* TO '<user name>' @ '<Slave ip>'
 IDENTIFIED BY '<password>'
```
- Refresh
```bash
mysql> flush privileges;
```
2. Config Slave
- Open Relay log
``` bash
vim /etc/my.cnf
[mysqld]
server-id=2
relay-log=slave-relay-bin
relay-log-index=slave-bin.index
```
- Restart MySQL service
``` bash
/etc/init.d/mysql stop
/etc/init.d/mysql start
```
- Change master
```bash
mysql> change master to master_host = '<master ip>', master_port=<master port>
, master_user='<user name>', master_password='<password>', master_log_file='<THE RSULT OF SHOW MASTER STATUS>
, naster_log_pos=0;'
```
- Start slave
``` bash
mysql> start slave
```
- Show status
``` bash
mysql> show slave status \G;
```
## Coding for separating read and write