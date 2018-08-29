package com.rajeev.design.pattern;

/**
 * @author RA016GU
 *
 */

public class FactoryPatternExample {

	public static class Server implements Computer {
		String ram;
		String hdd;
		String cpu;

		public Server(String ram, String hdd, String cpu) {
			this.ram = ram;
			this.hdd = hdd;
			this.cpu = cpu;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.rajeev.design.pattern.FactoryPatternExample.Computer#getRam()
		 */
		@Override
		public String getRam() {
			return ram;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.rajeev.design.pattern.FactoryPatternExample.Computer#getHDD()
		 */
		@Override
		public String getHDD() {
			return hdd;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.rajeev.design.pattern.FactoryPatternExample.Computer#getCPU()
		 */
		@Override
		public String getCPU() {
			return cpu;
		}

		@Override
		public String toString() {
			return "SERVER [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + "]";
		}

	}

	public static class PC implements Computer {
		String ram;
		String hdd;
		String cpu;

		public PC(String ram, String hdd, String cpu) {
			this.ram = ram;
			this.hdd = hdd;
			this.cpu = cpu;
		}

		@Override
		public String getRam() {
			return ram;
		}

		@Override
		public String getHDD() {
			return hdd;
		}

		@Override
		public String getCPU() {
			return cpu;
		}

		@Override
		public String toString() {
			return "PC [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + "]";
		}

	}

	public interface Computer {

		public String getRam();

		public String getHDD();

		public String getCPU();
	}

	public static class ComputerFactory {

		public static Computer getComputer(ComputerType type, String ram, String hdd, String cpu) {
			Computer comp = null;
			switch (type) {
			case PC:
				comp = new PC(ram, hdd, cpu);
				break;
			case SERVER:
				comp = new Server(ram, hdd, cpu);
				break;
			default:
				break;
			}

			return comp;
		}
	}

	public enum ComputerType {
		PC, SERVER
	}

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(ComputerType.PC, "1GB RAM", "2TB HDD", "2-core CPU");
		System.out.println(pc.toString());

		Computer server = ComputerFactory.getComputer(ComputerType.SERVER, "10GB RAM", "20TB HDD", "20-core CPU");
		System.out.println(server.toString());
	}

}
