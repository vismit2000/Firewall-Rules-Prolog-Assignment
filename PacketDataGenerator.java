package Prolog;

import java.util.Random;

/*
 * List is ['*Src_ip','*Dst_ip','*Adapter_num','*Protocol_type','*Port_num',
 * 'Icmpv6_type','Icmpv6_Msgcode','*Vlan_Id',
 * '*TCPSrc','*TCPDst','*UDPSrc','*UDPDst','*IPV6Src','*IPV6Dst','ICMPType','ICMPCode']
 */
public class PrologDataGenerator {

	public static void main(String[] args) 
	{
		Random r = new Random();
		String src_ip,dest_ip,proto_type,adapter_no;
		String ipv6_src,ipv6_dst;
		int proto_port_no,VLAN_ID,tcp_src_no,tcp_dst_no,udp_src_no,udp_dst_no;
		int icmpType,icmpCode,icmpv6Type,icmpv6Code;
		String[] proto_type_arr = {"TCP","FTP","ICMP","UDP"};
		String[] adapterTypes = {"A","B","C","D","E","F","G","H","any"};
		
		for(int i=0;i<100;i++)
		{
			
			icmpType=r.nextInt(65535);
			VLAN_ID=r.nextInt(65535);
			icmpCode = r.nextInt(65535);
			icmpv6Type=r.nextInt(65535);
			icmpv6Code = r.nextInt(65535);
			adapter_no = adapterTypes[r.nextInt(9)];
			proto_port_no = r.nextInt(255);
			proto_type = proto_type_arr[r.nextInt(3)];
			tcp_src_no = r.nextInt(65535);
			tcp_dst_no = r.nextInt(65535);
			udp_src_no = r.nextInt(65535);
			udp_dst_no = r.nextInt(65535);
			src_ip = r.nextInt(255)+"."+r.nextInt(255)+"."+r.nextInt(255)+"."+r.nextInt(255);
			dest_ip = r.nextInt(255)+"."+r.nextInt(255)+"."+r.nextInt(255)+"."+r.nextInt(255);
			ipv6_src = r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255);
			ipv6_dst = r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255)+":"+r.nextInt(255);
			String packet = "packet(pack"+(i+1)+",['"+src_ip+"','"+dest_ip+"','"+adapter_no+"','"+proto_type+"','"+proto_port_no+"','"+icmpv6Type+"','"+icmpv6Code+"','"+VLAN_ID+"','"+tcp_src_no+"','"+tcp_dst_no+"','"+udp_src_no+"','"+udp_dst_no+"','"+ipv6_src+"','"+ipv6_dst+"','"+icmpType+"','"+icmpCode+"']).";
			System.out.println(packet);
		}
	}

}
