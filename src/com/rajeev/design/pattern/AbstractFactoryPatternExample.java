package com.rajeev.design.pattern;

import com.rajeev.design.pattern.FactoryPatternExample.Computer;

/**
 * @author RA016GU
 *
 */
public class AbstractFactoryPatternExample {

	public static class PC implements Computer {
		String ram;
		String hdd;
		String cpu;

		public PC(String ram, String hdd, String cpu) {
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

	}

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

	}

	public static class ServerFactory implements AbstractComputerFactory {
		String ram;
		String hdd;
		String cpu;

		public ServerFactory(String ram, String hdd, String cpu) {
			this.ram = ram;
			this.hdd = hdd;
			this.cpu = cpu;
		}

		@Override
		public Computer createComputer() {
			return new Server(this.ram, this.hdd, this.cpu);
		}

	}

	public static class PCFactory implements AbstractComputerFactory {
		String ram;
		String hdd;
		String cpu;

		public PCFactory(String ram, String hdd, String cpu) {
			this.ram = ram;
			this.hdd = hdd;
			this.cpu = cpu;
		}

		@Override
		public Computer createComputer() {
			return new PC(this.ram, this.hdd, this.cpu);
		}

	}

	public interface AbstractComputerFactory {

		public Computer createComputer();

	}

	public static class ComputerFactory {
		public static Computer createComputer(AbstractComputerFactory acf) {
			return acf.createComputer();
		}

	}

	public static void main(String[] args) {
		Computer pc = ComputerFactory.createComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
		System.out.println(pc);

		Computer server = ComputerFactory.createComputer(new ServerFactory("20 GB", "5000 GB", "2.40 GHz"));
		System.out.println(server);

	}
}
