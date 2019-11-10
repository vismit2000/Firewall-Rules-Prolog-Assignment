## Firewall Rules
Assignment for Logic in Computer Science (CS F214) course at BITS Pilani - Implementing rules for a Firewall (over a network) in Prolog language.

To run this project, you will need SWI Prolog which can be downloaded [here](http://www.swi-prolog.org/download/stable).

## User Interface
- The top level procedure is printStatus(<’packetname’>)

- The procedure prints Packet Accepted, Packet Rejected or Packet Dropped. If there is a conflict in the status of the packet according to the rules, priority is given to reject, then drop, and then accept.

- Example:  
```
    ?- printStatus('pack1').
    Packet Accepted
```

## Rule base
- The rule base contains rules as required. Each rule starts with an accept,reject or drop predicate. Each is a unary predicate, which takes a string argument.

- The default behaviour of the program is to accept; which means that if the packet is unmatched to any of the rules, it will be accepted. 

- Examples:
```
    accept(‘ip src addr 172.24.6.31’).
    reject(‘adapter C-F’).
    drop(‘ether vid 3-199 proto 0x0800,0x86dd’).
```

## Packet Input Format
- Each packet is encoded in the database within the predicate packet(<'packet_name',attribute_list>).
'packet_name' is any string.
attribute_list is a list containing 16 attributes of the packet, all enclosed in quotes. Not all of these attributes will be applicable for a given packet.
```
['Src_ip','Dst_ip','Adapter_num','Protocol_type', 'Icmpv6_type','Icmpv6_Msgcode','Vlan_Id', 'TCPSrc','TCPDst','UDPSrc','UDPDst','IPV6Src','IPV6Dst','ICMPType','ICMPCode','protocolId']
```

- The terms are described below:

    - Src_ip: The ipv4 address of the source.
    - Dst_ip: The ipv4 address of the destination.
    - Adapter_num: Adapter number, an upper case character between A and H. Note: Specified in double quotes rather than single.
    - Protocol_type: The protocol type specified in ip datagram clause (tcp/udp) Note: Specified in double quotes rather than single.
    - Icmpv6_type: Protocol type specified in icmpv6 conditions(integer)
    - Icmpv6_Msgcode: message code specified in icmp conditions(integer).
    - Vlan_Id: Virtual LAN Id (Integer, specified in the ethernet clause) 
    - TCPSrc:TCP port number of source between 0 and 65535.
    - TCPDst:TCP port number of destination between 0 and 65535.
    - UDPSrc:UDP port number of source between 0 and 65535.
    - UDPDst:UDP port number of destination between 0 and 65535.
    - IPV6Dst: ipv6 address of source
    - IPV6Dst: ipv6 address of destination
    - ICMPType: Protocol type in ipv6 
    - ICMPCode: Message code in ipv6
    - protocol-id : The protocol id specified in the 'ether proto <protocol_id>' clause

The parameters for ipv4 and ipv6 are mutually exclusive; so are the parameters for tcp and udp. For the values not to be given, an asterisk '*' should be used.

Examples can be found in FactsDatabase.pl

## IMPORTANT INFORMATION RELATED TO THE FUNCTIONALITY OF THE PROGRAM

- Clauses having multiple optional parameters should be dealt with carefully. Their permutation follow a STRICT fashion.
For Example -
The 2 separate rules - 'accept tcp src addr 192.168.17.10' and 'accept tcp dst addr 192.168.17.15'
are NOT THE SAME as the single rule 'accept tcp dst addr 192.168.17.15 src addr 192.168.17.10'
Both are treated differently, i.e. considering the rule 'accept tcp src addr 192.168.17.10 dst addr 192.168.17.15', the only packet that will match this will be the one where BOTH src and dst parameters match the rule, and not the ones where only one of the parameter matches.
Similarly, packets which specify both src and dst parameter will look only for rules having both the parameter mentioned.

- There might be situations where multiple rules apply to the given packet.
These rules might collide with each other's result. In such situations, the following convention is followed -
    (i) If the colliding rules are of the same Clause/Condition, then the rule APPEARING FIRST in the order of rules will be give higher priority, i.e. its output action will be considered.
    (ii) If the colliding rules are of different Clauses/Conditions, then priority will be decided based on the output actions of the rules.
    The priority order in this case is - Reject > Drop > Accept.

- The 'any' keyword will be applied to any value of the parameter, except when the parameter is left empty (empty string ""), i.e. some value for the parameter is needed for the rule with 'any' to apply.

- Default action is taken as 'accept'. This is for the situations when :-
    (i) No rule matches the clause/condition in the packet.
    (ii) Numerical/Alphabetic values in a clause/condition lies out of the ranges mentioned in 'CLAUSES.txt' file.
    (iii) Wrong syntax is used in writing down the clause/condition.

- Wherever you wish to use decimal / hexadecimal / octal values, use correct prefixes :-
    (i) Octal - '0', e.g. 10 = 012
    (ii) Hexadecimal - '0x', e.g. 35 = 0x23
    (iii) Decimal - No prefix

- Range-type parameters should follow the order of minimum value followed by maximum value. Wrong order will give ambiguous results.
For example- `35-10` is wrong syntax, and will not give the correct results

- NOT expressions should be used carefully. Only valid expressions should be used inside !(...). Using invalid expressions will lead to ambiguous results. For example !(asdf) is invalid for any clause/condition.

## Group Members

- Harpinder Jot Singh [Github](https://github.com/HarpinderJotSingh) [LinkedIn](https://www.linkedin.com/in/harpinder-jot-singh-248b92155/?originalSubdomain=in)
- Vishal Mittal [Github](https://github.com/vismit2000) [LinkedIn](https://www.linkedin.com/in/vishal-mittal-113494157/)
- Yash Vijay
