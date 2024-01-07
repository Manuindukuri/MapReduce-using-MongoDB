# MapReduce and MongoDB 
[![Static Badge](https://img.shields.io/badge/MongoDB-black?style=for-the-badge&logo=MongoDB)](https://www.mongodb.com/)
[![Static Badge](https://img.shields.io/badge/java-blue?style=for-the-badge&logo=java)](https://dev.java/)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/)
[![Static Badge](https://img.shields.io/badge/mapreduce-yellow?style=for-the-badge)](https://www.databricks.com/glossary/mapreduce)
[![Static Badge](https://img.shields.io/badge/linux-black?style=for-the-badge&logo=linux)](https://www.linux.org/)
[![Static Badge](https://img.shields.io/badge/shell-grey?style=for-the-badge&logo=shell)](https://www.shellscript.sh/)

## Overview
The project is a comprehensive exploration of how MapReduce and the Aggregation Pipeline within MongoDB can be harnessed for processing and analyzing substantial datasets. It encompasses various datasets, notably the NYSE stock prices and the Movielens movie ratings, and leverages both MapReduce and the Aggregation Pipeline for effective data analysis. Additionally, it delves into web access log analysis using Java and MongoDB.

![Alt text](<ProjectImage.png>)

## Key Components
The project consists of several crucial components:
### 1. Dataset Importing Scripts: 
The project includes .bat and .sh scripts for importing datasets into MongoDB. These scripts streamline the process of importing data, enhancing efficiency and ensuring that the datasets are readily available for analysis.

### 2. MapReduce Analysis:
NYSE Dataset: 
Calculate the average stock price, addressing challenges like non-associative operations using a Finalizer.

Movielens Dataset: 
Analyze user demographics (gender distribution) and movie statistics (movies per year and per rating).

### 3. Aggregation Pipeline:
Repetition of MapReduce analyses using MongoDB's Aggregation Pipeline for comparison and efficiency analysis.

### 4. Access Log Analysis: 
This part of the project involves the development of a Java application to process web access logs. Once the data is ingested into MongoDB, MapReduce and Aggregation Pipeline are employed to analyze web page visits. Two key analyses are performed:

- Counting Webpage Visits by IP Address: The project determines the number of times any webpage was visited by the same IP address, helping identify frequently accessed pages.

- Counting Webpage Visits by Month: By analyzing the access logs, the project calculates the number of times any webpage was visited each month, providing insights into monthly traffic patterns.

## Requirements
### MongoDB: 
The database system is essential for storing and managing the datasets as well as executing MapReduce and Aggregation Pipeline operations.

### Java: 
A Java runtime environment is required to run the Java application responsible for processing web access logs.

### Scripting Environment: 
The project provides .bat and .sh scripts for data importing. You should have a suitable scripting environment to execute these scripts.

## Conclusion
This project demonstrates the power and flexibility of MongoDB in handling large datasets using both MapReduce and the Aggregation Pipeline. It covers a wide range of data analysis tasks, from financial data to movie ratings and web access logs. Feel free to explore and adapt the provided scripts and methodologies for your own data analysis needs.

## License
This project is licensed under the MIT License.