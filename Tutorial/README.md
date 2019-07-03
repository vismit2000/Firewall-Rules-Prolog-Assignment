# PrologAssignment
A prolog Program on Firewall Rules

## Firewall , How it Works?

A firewall functions analogous to a guard at BITS gate, looking at each packet of data to determine where it came from and where it is going, or both, and deciding if the packet should be accepted and allowed to  continue on its way or if it should be denied or dropped.  As in the real world, a denied packet is turned from the gate and sent back to where it came from.  Unlike the real world, a dropped packet just ceases to exist.

## What is a firewall policy or ruleset?

When someone decides to implement a firewall they generally have a good idea what it should do.  For example, the firewall should allow traffic to come to my web server but should deny all other traffic. This statement is an example of a firewall policy.  The person implementing this policy in the firewall, sometimes known as a firewall administrator, will translate this policy into a series of technical statements called a ruleset that tells the hardware or software what to do

## Writing a Firewall Rule

Most traffic that will reach your firewall will be Internet Protocol (IP) traffic using one of the three major Transport Layer protocols: TCP, UDP, or ICMP.  All three types have a source address and a destination address that designate the computer that sent or is to receive a packet of data uniquely.  Both TCP and UDP also have port numbers, a number between 0 and 65,535 that helps identify the application that initiated the connection.  For example, most web servers use TCP port 80, so a packet headed for a web server should have the destination address of the web server and a destination port number of 80.  ICMP does not use port numbers, but instead has a type code that identifies what the purpose of the packet is.  ICMP is generally used for debugging network problems or informing systems of a problem.  If you’ve ever used the ping command, you’ve generated ICMP packets.

TCP packets have flags that indicate the the state of a connection between two hosts.  These flags have names like SYN, FIN, ACK, and RST.  A packet that is meant to initiate a connection will have only the SYN flag.  All subsequent communication between two systems would have the ACK flag.  Firewalls can be configured to look for packets that have only the SYN flag set and treat them as new connections where packets with an ACK flag are presumed to be part of an existing connection.  There are security implications to this because the sender of a packet can control what flags are present, but it can be an effective first pass at identifying new versus existing connections..

## How firewall controls traffic? 

Firewalls use one or more of three methods to control traffic flowing in and out of the network:

- Packet filtering - Packets (small chunks of data) are analyzed against a set of filters. 
- Packets that make it through the filters are sent to the requesting system and all others are discarded.
- Proxy service - Information from the Internet is retrieved by the firewall and then sent to the requesting system and vice versa. 
- Stateful inspection - A newer method that doesn't examine the contents of each packet but instead compares certain key parts of the packet to a database of trusted information. Information traveling from inside the firewall to the outside is monitored for specific defining characteristics, then incoming information is compared to these characteristics. If the comparison yields a reasonable match, the information is allowed through. Otherwise it is discarded.

## Firewall Configuration
One can add or remove filters based on several conditions. Some of these are:
 
- IP addresses - Each machine on the Internet is assigned a unique address called an IP address. IP addresses are 32-bit numbers,referred to as “IPv4", normally expressed as four "octets" in a "dotted decimal number." A typical IP address looks like this: 216.27.61.137. For example, if a certain IP address outside the company is reading too many files from a server, the firewall can block all traffic to or from that IP address. Due  to  the  rapidly diminishing number of IPv4 addresses available as more and more computerized devices connect to the Internet, a new address format, dubbed “IPv6”, has recently begun to see use. This version uses a 128 bit number, which allows a far wider range of  possible addresses.  Each  packet  specifies both the  IP it  initially came  from, which is referred to as the source IP address, and the IP address that it is trying to reach, known as the destination IP addresses

- Domain Names - readable names for replacemenet of ip addresses

- Protocols - The protocol is the pre-defined way that someone who wants to use a service talks with that service. The "someone" could be a person, but more often it is a computer program like a Web browser. Protocols are often text, and simply describe how the client and server will have their conversation. The http in the Web's protocol. Some common protocols that you can set firewall filters for include:

```
    IP (Internet Protocol) - the main delivery system for information over the Internet
    TCP (Transmission Control Protocol) - used to break apart and rebuild information that travels over the Internet
    HTTP (Hyper Text Transfer Protocol) - used for Web pages
    FTP (File Transfer Protocol) - used to download and upload files
    UDP (User Datagram Protocol) - used for information that requires no response, such as streaming audio and video
    ICMP (Internet Control Message Protocol) - used by a router to exchange the information with other routers
    SMTP (Simple Mail Transport Protocol) - used to send text-based information (e-mail)
    SNMP (Simple Network Management Protocol) - used to collect system information from a remote computer
    Telnet - used to perform commands on a remote computer
```

- Ports - Any server machine makes its services available to the Internet using numbered ports, one for each service that is available on the server. For example, if a server machine is running a Web (HTTP) server and an FTP server, the Web server would typically be available on port 80, and the FTP server would be available on port 21. A company might block port 21 access on all machines but one inside the company.Ports are used as a way to identify what the packet is used for and to forward it to the desired process.   There  are  over  65,000  ports  available  though  the  majority  are  unused on  a  daily  basis.   Certain  functions  such  as  HTTP  for  web  browsers  have  an informally agreed upon port.  While the port can be changed if so desired, these defaults simplify the connection for users.  Port numbers are usually added to the end of an IP Address and separated by a colon.  For example,  a packet that is estined for IP address 230.105.4.32 and port 80 would have a destination address of 230.105.4.32:80
 
- Specific words and phrases - This can be anything. The firewall will sniff (search through) each packet of information for an exact match of the text listed in the filter. For example, you could instruct the firewall to block any packet with the word "X-rated" in it. The key here is that it has to be an exact match. The "X-rated" filter would not catch "X rated" (no hyphen). But you can include as many words, phrases and variations of them as you need.

- Network Adapter-A network adapter is the component of a computer’s internal hardware that is used for communicating over a network with another computer. It enable a computer to connect with another computer, server or any networking device over an LAN connection. A network adapter can be used over a wired or wireless network.

## 802.1Q –
It is IEEE standard method of frame tagging. If user wants to trunk between a Cisco switch link and a different brand switch link, then have to use 802.1Q encapsulation for the trunk to work.

In 802.1Q, the trunking device inserts a 4-byte tag into the original frame and recomputes the frame check sequence (FCS) before the device sends the frame over the trunk link. At the receiving end, the tag is removed and the frame is forwarded to the assigned VLAN. 

## Subnet Mask

In an IP address,The slash and the number following it is just a shorthand way to write a subnet mask. It's called CIDR (Classless Inter-Domain Routing) notation. It's also commonly referred to as the prefix length. The number after the slash represents the number of consecutive 1's in the subnet mask. For example, 192.168.10.0/24 is equal to the network 192.168.10.0 with a 255.255.255.0 subnet mask. If you convert 255.255.255.0 to binary, you end up with 24 consecutive 1's: 11111111.11111111.11111111.00000000

Another example could be 10.0.0.0/8. 8 consecutive 1's in the subnet mask gives you 11111111.00000000.00000000.00000000 or 255.0.0.0.

### Official Documentation by IBM here

- [Firewall rule language](https://www.ibm.com/support/knowledgecenter/en/SSB2MG_4.6.0/com.ibm.ips.doc/concepts/firewall_rules_language.htm)

- [Firewall rule syntax](https://www.ibm.com/support/knowledgecenter/SSB2MG_4.6.0/com.ibm.ips.doc/references/firewall_rule_syntax.htm)

- [Firewall rule examples](https://www.ibm.com/support/knowledgecenter/SSB2MG_4.6.0/com.ibm.ips.doc/references/firewall_rule_examples.htm)