import socket, ssl
import time
import datetime
from traceback import print_tb

context = ssl.SSLContext()
context.options |= ssl.OP_NO_TICKET #diable session ticket
context.verify_mode = ssl.CERT_NONE # disable cert. validation
context.check_hostname = False  # disable host name checking
dn = "oliverw14.pythonanywhere.com" # example of domain to connect to
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM) # create socket
s.settimeout(5) # set timeout
sslSocket = context.wrap_socket(s, server_hostname = dn) # wrap socket into TLS context

try:
    
    begin = time.process_time() # start timer
    sslSocket.connect((dn, 443)) # TLS socket connection
    perf = time.process_time() - begin # end timer

    print ("Success! Performance time for TLS connection is: ", perf*1000) #convert from sec. to ms by multiplying with 1000
    #with open(r"PythonResults.txt", 'r') as fp:
    #    for count, line in enumerate(fp):
    #        pass
    #print('Total Lines', count + 1)
    f = open("PythonResults.txt", "a")
    perf = repr(perf*1000)
    #count = repr(count)
    f.write(perf)
    f.write("\n")
    f.close


except (ssl.SSLError, ssl.SSLEOFError, ssl.CertificateError,ssl.SSLSyscallError, ssl.SSLWantWriteError, ssl.SSLWantReadError,ssl.SSLZeroReturnError) as e1:
    print(e1)
    sslSocket.close() # close the socket
except Exception as e2:
    print(e2)
    sslSocket.close() # close the socket 