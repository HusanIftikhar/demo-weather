FROM jenkins/jenkins:2.222.4
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY seedJob.xml /usr/share/jenkins/ref/jobs/seed-job/config.xml
git
ENV JAVA_OPTS -Djenkins.install.runSetupWiard=false