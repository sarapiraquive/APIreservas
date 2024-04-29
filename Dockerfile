FROM centos:7.9.2009
 
RUN yum install httpd -y
 
 
COPY web /var/www/html
 
 
CMD apachectl -DFOREGROUND