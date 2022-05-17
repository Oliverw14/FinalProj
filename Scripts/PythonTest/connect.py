#Programmer - Oliver Wilson 1447621
#Purpose - Final Project SSL Test
#Date 16/05/2022

import socket, ssl
import time

begin = time.process_time_ns() # start timer
context = ssl.SSLContext(ssl.PROTOCOL_TLSv1_2)
context.options |= ssl.OP_ALL #enable session ticket
context.verify_mode = ssl.CERT_REQUIRED # enable cert. validation
context.check_hostname = True  #check hostname
context.load_default_certs()
dn = "oliverw14.pythonanywhere.com" # domain to connect to

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # create socket
s.settimeout(5) # set timeout
sslSocket = context.wrap_socket(s, server_hostname = dn) # wrap socket into TLS context

try:
    
    sslSocket.connect((dn, 443)) # TLS socket connection
    perf = time.process_time_ns() - begin # end timer

    print ("Success! Performance time for TLS connection is: ", perf/1000000) #convert from nano. to ms by dividing with 1000000
    #with open(r"PythonResults.txt", 'r') as fp:
    #    for count, line in enumerate(fp):
    #        pass
    #print('Total Lines', count + 1)
    f = open("PythonResults.txt", "a")
    perf = repr(perf/1000000)
    #count = repr(count)
    f.write(perf)
    f.write("\n")
    f.close
    sslSocket.close() # close the socket


except (ssl.SSLError, ssl.SSLEOFError, ssl.CertificateError,ssl.SSLSyscallError, ssl.SSLWantWriteError, ssl.SSLWantReadError,ssl.SSLZeroReturnError) as e1:
    print(e1)
    sslSocket.close() # close the socket
except Exception as e2:
    print(e2)
    sslSocket.close() # close the socket 
