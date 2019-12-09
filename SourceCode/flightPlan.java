// Driver class


import java.io.*;

public class flightPlan {
	// Main function 
	public static void main(String[] args) throws IOException {
		
		// create graph of cities
		GraphCities cities = new GraphCities();
		BufferedReader in = new BufferedReader(new FileReader("FlightData.txt")); // reader to read input from file
		int numLine = Integer.parseInt(in.readLine());
		String line;
		String[] values;
		for (int i = 0; i < numLine; i++) {
			line = in.readLine();
			values = line.split("\\|");
			cities.setLeg(values[0], values[1], Double.parseDouble(values[2]), Integer.parseInt(values[3]));
		}
		in.close();
		
		// process requested flights
		in = new BufferedReader(new FileReader("PathsToCal.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("FlightPlan.txt")); // buffered writer to write to file
		numLine = Integer.parseInt(in.readLine());
		for (int i = 0; i < numLine; i++) {
			line = in.readLine();
			values = line.split("\\|");
			out.write("Flight " + Integer.toString(i + 1) + ": " + values[0] + ", " + values[1] + " ");
			if (values[2].equalsIgnoreCase("T"))
				out.write("(Time)\n" + cities.flightPlan(values[0], values[1], "time"));
			else
				out.write("(Cost)\n" + cities.flightPlan(values[0], values[1], "cost"));
			out.newLine();
		}
		in.close();
		out.close();
	}
}
