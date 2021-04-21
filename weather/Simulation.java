package weather;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import aircraft.AircraftFactory;
import exceptions.BadCoordinatesException;
import exceptions.UnknownTypeException;

class Simulation {
	private static WeatherTower	tower = new WeatherTower();
	private static int requiredSimulation;

	private static class ParseException extends Exception {
		ParseException(String errorMessage) {
			super(errorMessage);
		}
	}

	private static void parse(String file) throws ParseException {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String currentLine = reader.readLine();

			requiredSimulation = Integer.parseInt(currentLine);
			if (requiredSimulation <= 0)
				throw new NumberFormatException("Required simulation can't be <= 0");
			while ((currentLine = reader.readLine()) != null) {
				String[] infos = currentLine.split(" ");
				if (infos.length != 5)
					throw new ParseException("Invalid line format");
				AircraftFactory.newAirCraft(infos[0], infos[1],
				Integer.parseInt(infos[2]), Integer.parseInt(infos[3]), Integer.parseInt(infos[4])).registerTower(tower);
			}
		} catch (IOException | NumberFormatException e) {
			throw new ParseException(e.getMessage());
		} catch (BadCoordinatesException e) {
			throw new ParseException("BadCoordinatesException: " + e.getMessage());
		} catch (UnknownTypeException e) {
			throw new ParseException("UnknownTypeException: " + e.getMessage());
		}
	}

	private static void run() {
		while (requiredSimulation-- > 0)
			tower.changeWeather();
	}

	public static void main(String av[]) {
		if (av.length != 1) {
			System.err.println("Invalid number of arguments.");
			System.exit(1);
		}
		try {
			parse(av[0]);
		} catch (ParseException e) {
			System.err.println("ParseException: " + e.getMessage());
			System.exit(1);
		}
		run();
	}
}
