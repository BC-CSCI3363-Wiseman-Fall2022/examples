pkg1 = echo1
pkg2 = echo2
pkg3 = echo3
pkg4 = UDPecho1
pkg5 = UDPecho2
source = $(pkg1)/EchoServer.java $(pkg1)/EchoClient.java $(pkg2)/EchoServer.java $(pkg2)/EchoClient.java $(pkg3)/EchoServer.java $(pkg3)/EchoClient.java $(pkg4)/EchoServer.java $(pkg4)/EchoClient.java $(pkg5)/EchoServer.java $(pkg5)/EchoClient.java
jc = javac

classfiles = $(source:.java=.class)

all: $(classfiles)

%.class: %.java
	$(jc) $<

clean:
	rm -f $(pkg1)/*.class $(pkg2)/*.class $(pkg3)/*.class $(pkg4)/*.class $(pkg5)/*.class
