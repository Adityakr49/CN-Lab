# CN Lab
Computer Networks Lab completed as part of the academic curriculum at SJCE, JSS STU

## Part A: Implementations

### 1. Network Configuration
- A. Use appropriate tools to find host name, IP address, physical address, subnet mask, default gateway, etc. (Hint: ipconfig). Explore different options available with the tool.
- B. On the host system, identify TCP connections, ports on which the computer is listening, Ethernet statistics, the IP routing table, IPV4 statistics, and IPV4 statistics, etc. using appropriate tools (Hint: netstat). Explore different options available with the tool.

### 2. Frame Sorting
Write a program to sort frames using appropriate sorting techniques.

### 3. Error Detection
Write a program for error-detecting code using CRC-CCITT (16-bits).

### 4. Shortest Path
Write a program to find the shortest path between vertices using the Bellman-Ford algorithm.

### 5. File Transfer
Using TCP/IP sockets, write a client-server program to make the client send the file name and have the server send back the contents of the requested file if present.

### 6. Datagram Socket
Write a program on datagram sockets for client-server communication to display messages on the client side, typed at the server side.

### 7. RSA Encryption
Write a program for the simple RSA algorithm to encrypt and decrypt data.

### 8. Congestion Control
Write a program for congestion control using the leaky bucket algorithm and token bucket algorithm.

### 9. RED Congestion Control
Write a program to implement Random Early Detection (RED) congestion control algorithm.

## Part B: Simulation Experiments

### 10. Point-to-Point Network
a. Implement a three-node point-to-point network with duplex links between them. Set the queue size, vary the bandwidth, and find the number of packets dropped.
b. Implement the transmission of ping messages/trace route over a network topology consisting of 6 nodes and find the number of packets dropped due to congestion.

### 11. Ethernet LAN and Wireless LAN
a. Implement an Ethernet LAN using n nodes and set multiple traffic nodes. Plot the congestion window for different source/destination pairs.
b. Implement a simple Extended Service Set (ESS) with transmitting nodes in a wireless LAN by simulation and determine the performance with respect to the transmission of packets.

### 12. GSM and CDMA Simulation
a. Implement and study the performance of GSM on NS2/NS3 (Using MAC layer) or an equivalent environment.
b. Implement and study the performance of CDMA on NS2/NS3 (Using a stack called Call Net) or an equivalent environment.

