# Simple Java VPN Simulation

This project provides a simplified example of a Virtual Private Network (VPN) simulation using Java sockets. Please note that this is a basic demonstration for educational purposes and does not offer the security or features of a real VPN solution.

## Overview

The project consists of two components: a VPN server and a VPN client. The client establishes a connection with the server and sends data, which the server then echoes back to the client.

## Components

### VPN Server

The VPN server listens for incoming connections on a specified port. When a client connects, the server sets up a new thread to handle the communication with that client. The server reads data from the client and immediately sends it back, effectively simulating the behavior of a VPN server.

To run the VPN server, execute the following command:

```bash
java VpnServer.java
