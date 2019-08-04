# Datacenter-simulator

A Java-based simulator to represent the energy consumption behavior of datacenters (DC).
The simulation is based on the following scenario:

Two DCs having the same grid and renewable energy supplies, shifts workload to each other. 
Each DC has two servers, workload is shifted to other DC when all servers are busy of a DC.
Based on the size (byte) of workload, the server goes in busy status for a specific time.

Datasets:
1. Workload: Clarknet dataset which consists of 2-weeks HTTP request to server
2. Power supply: UK power grid and solar energy dataset

