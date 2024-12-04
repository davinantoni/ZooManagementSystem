package org.softwire.training.zoo;

import org.softwire.training.zoo.commands.ChangeStateCommand;
import org.softwire.training.zoo.commands.Command;
import org.softwire.training.zoo.commands.CommandInvoker;
import org.softwire.training.zoo.decorator.AquaticEnclosure;
import org.softwire.training.zoo.decorator.BasicEnclosure;
import org.softwire.training.zoo.decorator.Enclosure;
import org.softwire.training.zoo.decorator.TropicalEnclosure;
import org.softwire.training.zoo.facade.ZooFacade;
import org.softwire.training.zoo.factories.AnimalFactory;
import org.softwire.training.zoo.factories.LargeAnimalFactory;
import org.softwire.training.zoo.factories.SmallAnimalFactory;
import org.softwire.training.zoo.models.AbstractAnimal;
import org.softwire.training.zoo.models.Animal;
import org.softwire.training.zoo.models.Keeper;
import org.softwire.training.zoo.models.LargeAnimal;
import org.softwire.training.zoo.models.Lion;
import org.softwire.training.zoo.models.Promo;
import org.softwire.training.zoo.models.Rabbit;
import org.softwire.training.zoo.models.SmallAnimal;
import org.softwire.training.zoo.models.Zebra;
import org.softwire.training.zoo.observer.NormalVisitor;
import org.softwire.training.zoo.observer.PromoObserver;
import org.softwire.training.zoo.observer.VIPVisitor;
import org.softwire.training.zoo.observerable.Zoo;
import org.softwire.training.zoo.services.FeedingScheduler;
import org.softwire.training.zoo.services.GroomingScheduler;
import org.softwire.training.zoo.singleton.Singleton;
import org.softwire.training.zoo.states.HappyState;
import org.softwire.training.zoo.strategies.HopStrategy;
import org.softwire.training.zoo.strategies.MovementStrategy;
import org.softwire.training.zoo.strategies.RoarStrategy;
import org.softwire.training.zoo.strategies.SoundStrategy;
import org.softwire.training.zoo.strategies.SquealStrategy;
import org.softwire.training.zoo.strategies.WalkStrategy;
import org.softwire.training.zoo.templatemethod.LargeAnimalFeedingRoutine;
import org.softwire.training.zoo.templatemethod.SmallAnimalFeedingRoutine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
	Scanner scan = new Scanner(System.in);
	Zoo zoo = new Zoo();
	AnimalFactory largeFactory = new LargeAnimalFactory();
	AnimalFactory smallFactory = new SmallAnimalFactory();
	ArrayList<AbstractAnimal> animals = new ArrayList<>();
	ArrayList<Enclosure> enclosures = new ArrayList<>();
	Singleton db = Singleton.getInstance();
	
	public App() {
//		List<LargeAnimal> largeAnimals = Arrays.asList(
//                new Lion(LocalDate.of(2010, 4, 28)),
//                new Lion(LocalDate.of(2012, 5, 11)),
//                new Zebra(LocalDate.of(2008, 12, 1))
//        );
//        List<SmallAnimal> smallAnimals = Collections.singletonList(
//                new Rabbit(LocalDate.of(2014, 1, 1))
//        );
//        List<Animal> animals = new ArrayList<>();
//        animals.addAll(largeAnimals);
//        animals.addAll(smallAnimals);
//
//        Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
//        Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);
//
//        List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);
//
//        Rabbit babyRabbit = new Rabbit(LocalDate.now());
//        smallAnimalKeeper.startLookingAfter(babyRabbit);
//
//        FeedingScheduler feedingScheduler = FeedingScheduler.getInstance();
//        GroomingScheduler groomingScheduler = GroomingScheduler.getInstance();
//
//        feedingScheduler.assignFeedingJobs(keepers);
//        groomingScheduler.assignGroomingJobs(keepers);
//        animals.forEach(System.out::println);
		
//    	LargeAnimal lion = (LargeAnimal) largeFactory.createAnimal("Lion", "Brown", "Land", LocalDate.of(2010, 4, 28),10);
//    	lion.performMove();
//    	lion.performSound();
//    	
//
//    	SmallAnimal rabbit = (SmallAnimal) smallFactory.createAnimal("Rabbit", "White", "Land", LocalDate.of(2010, 4, 28), 10);
//    	rabbit.performMove();
//    	rabbit.performSound();
    	
    	int chooseMenu = 0;
		
		do {
            System.out.println("Main Menu");
            System.out.println("---------");
            System.out.println("1. View All Animals");
            System.out.println("2. Add a New Animal");
            System.out.println("3. Quick Add Animal");
            System.out.println("4. Change Animal's Movement or Sound");
            System.out.println("5. Add New Zoo Enclosure");
            System.out.println("6. View All Zoo Enclosure");
            System.out.println("7. View All Observer");
            System.out.println("8. Add New Observer");
            System.out.println("9. Notify Observer Promo");
            System.out.println("10. Feed Animals");
            System.out.println("11. Scheduling Daily Care");
            System.out.println("12. Check Animal State");
            System.out.println("13. Exit");

            System.out.print("> ");
            chooseMenu = scan.nextInt();
            scan.nextLine();
            
            switch(chooseMenu) {
            case 1:
//            	if(animals.isEmpty()) {
//            		System.out.println("No animals.");
//            	}
//            	else {
//            		for (AbstractAnimal animal1 : animals) {
//            		    System.out.println("Name: " + animal1.getName());
//            		    System.out.println("Color: " + animal1.getColor());
//            		    System.out.println("Habitat: " + animal1.getHabitat());
//            		    System.out.println("Date of Birth: " + animal1.getDateOfBirth());
//            		    System.out.println("Movement Strategy: " + animal1.getMovementStrategy().getClass().getSimpleName());
//            		    System.out.println("Sound Strategy: " + animal1.getSoundStrategy().getClass().getSimpleName());
//            		    if (animal1 instanceof LargeAnimal) {
//            		        LargeAnimal largeAnimal = (LargeAnimal) animal1;
//            		        System.out.println("Strength Level: " + largeAnimal.getStrengthLevel());
//            		    } else if (animal1 instanceof SmallAnimal) {
//            		        SmallAnimal smallAnimal = (SmallAnimal) animal1;
//            		        System.out.println("Speed Level: " + smallAnimal.getSpeedLevel());
//            		    }
//            		    System.out.println("------------------------");
//            		}
//            	}
            	
            	viewAnimal();
            	break;
            case 2:
            	System.out.println("=== Add a New Animal ===");
                System.out.println("1. Large Animal");
                System.out.println("2. Small Animal");
                System.out.print("Choose category: ");
                int animalCategory = scan.nextInt();
                scan.nextLine(); 
                
                String name, color, habitat, move, sound;
                int level = 0;
                	
                System.out.print("Enter Animal's Name: ");
                name = scan.nextLine();
                System.out.print("Enter Animal's Color: ");
                color = scan.nextLine();
                System.out.print("Enter Animal's Habitat: ");
                habitat = scan.nextLine();
                System.out.print("Enter Animal's Movement [Walk | Hop](case sensitive): ");
                move = scan.nextLine();
                MovementStrategy movementStrategy = null;
                if (move.equals("Walk")) movementStrategy = new WalkStrategy();
                else if (move.equals("Hop")) movementStrategy = new HopStrategy();
                
                System.out.print("Enter Animal's Sound [Roar | Squeal](case sensitive): ");
                sound = scan.nextLine();
                SoundStrategy soundStrategy = null;
                if (sound.equals("Roar")) soundStrategy = new RoarStrategy();
                else if (sound.equals("Squeal")) soundStrategy = new SquealStrategy();
                
//                AbstractAnimal animal = null;
                if(animalCategory==1) {
                	System.out.print("Enter Animal's Strength Level: ");
                    level = scan.nextInt();
                    scan.nextLine();
//                    animal = largeFactory.createAnimal(name, color, habitat, LocalDate.of(2024, 11, 30), level,
//                    		movementStrategy, soundStrategy);
                    db.addAnimal(largeFactory.createAnimal(name, color, habitat, LocalDate.of(2024, 11, 30), level,
                    		movementStrategy, soundStrategy));
                }
                else {
                	System.out.print("Enter Animal's Speed Level: ");
                    level = scan.nextInt();
                    scan.nextLine();
//                    animal = smallFactory.createAnimal(name, color, habitat, LocalDate.of(2024, 11, 30), level,
//                    		movementStrategy, soundStrategy);
                    db.addAnimal(smallFactory.createAnimal(name, color, habitat, LocalDate.of(2024, 11, 30), level,
                    		movementStrategy, soundStrategy));
                }
//                animals.add(animal);
                System.out.println("Animal Added");
                scan.nextLine();
                
            	break;
            case 3:
            	viewAnimal();
            	int animalIndex = 0;
            	AbstractAnimal selectedAnimal = null;
            	String dobString = "";
            	if(db.checkDB() != 0) {
                    System.out.print("Choose an animal to duplicate: ");
                    animalIndex = scan.nextInt();
                    scan.nextLine();
                    
                    // prototype logic
                    selectedAnimal = db.getAnimals().get(animalIndex - 1);
                    LargeAnimal newLargeAnimal = null; 
                    SmallAnimal newSmallAnimal = null;
                    if(selectedAnimal instanceof LargeAnimal) {
                    	newLargeAnimal = (LargeAnimal)selectedAnimal.clone();
                    	 System.out.println("New animal data");
                    	newLargeAnimal.getInfo();
                    }
                    else {
                    	newSmallAnimal = (SmallAnimal)selectedAnimal.clone();
                    	 System.out.println("New animal data");
                    	newSmallAnimal.getInfo();
                    }
                    
                    System.out.println("Do you wish to modify the new animal? [yes | no](case sensitive): ");
                    String modify = scan.nextLine();
                    
                    if (modify.equals("yes")) {
                    	int field = 0;
                    	do {
                    		System.out.println("Choose field to modify: ");
                        	System.out.println("1. Name");
                        	System.out.println("2. Color");
                        	System.out.println("3. Habitat");
                        	System.out.println("4. Date of Birth");
                        	System.out.println("5. Movement Strategy");
                        	System.out.println("6. Sound Strategy");
                        	if(newSmallAnimal != null) System.out.println("7. Strength Level");
                        	else System.out.println("7. Speed Level");
                        	System.out.println("8. Exit");
                        	
                        	field = scan.nextInt(); scan.nextLine();
                        	switch(field) {
                        	case 1:
                        		System.out.print("Enter Animal's New Name: ");
                                name = scan.nextLine();
                                if(newLargeAnimal != null) newLargeAnimal.setName(name);
                            	else newSmallAnimal.setName(name);
                        		break;
                        		
                        	case 2:
                        		System.out.print("Enter Animal's Color: ");
                                color = scan.nextLine();
                                if(newLargeAnimal != null) newLargeAnimal.setColor(color);
                            	else newSmallAnimal.setColor(color);
                                break;
                                
                        	case 3:
                        		System.out.print("Enter Animal's Habitat: ");
                                habitat = scan.nextLine();    
                                if(newLargeAnimal != null) newLargeAnimal.setHabitat(habitat);
                            	else newSmallAnimal.setHabitat(habitat);
                                break;
                            
                        	case 4:
                        		System.out.print("Enter Animal's Date of Birth [YYYY-MM-DD]: ");
                        		dobString = scan.nextLine();  
                                LocalDate dob = LocalDate.parse(dobString);
                                if(newLargeAnimal != null) newLargeAnimal.setDateOfBirth(dob);
                            	else newSmallAnimal.setDateOfBirth(dob);
                                break;
                                
                        	case 5:
                        		System.out.print("Enter Animal's Movement [Walk | Hop](case sensitive): ");
                                move = scan.nextLine();
                                movementStrategy = null;
                                if (move.equals("Walk")) movementStrategy = new WalkStrategy();
                                else if (move.equals("Hop")) movementStrategy = new HopStrategy();
                                if(newLargeAnimal != null) newLargeAnimal.setMovementStrategy(movementStrategy);
                            	else newSmallAnimal.setMovementStrategy(movementStrategy);
                                break;
                                
                        	case 6:
                        		System.out.print("Enter Animal's Sound [Roar | Squeal](case sensitive): ");
                                sound = scan.nextLine();
                                soundStrategy = null;
                                if (sound.equals("Roar")) soundStrategy = new RoarStrategy();
                                else if (sound.equals("Squeal")) soundStrategy = new SquealStrategy();
                                if(newLargeAnimal != null) newLargeAnimal.setSoundStrategy(soundStrategy);
                            	else newSmallAnimal.setSoundStrategy(soundStrategy);
                                break;
                                
                        	case 7: 
                        		if(newLargeAnimal != null) {
                        			System.out.print("Enter Animal's Strength Level: ");
                                    level = scan.nextInt();
                                    scan.nextLine();
                                    newLargeAnimal.setStrengthLevel(level);
                        		}
                            	else {
                            		System.out.print("Enter Animal's Speed Level: ");
                                    level = scan.nextInt();
                                    scan.nextLine();
                                    newSmallAnimal.setSpeedLevel(level);
                            	}
                        		 break;
                        	}
                    	}while(field != 8);
                    }
                    
                    if(newLargeAnimal != null) db.addAnimal(newLargeAnimal);
                	else db.addAnimal(newSmallAnimal);
                    
                    System.out.println("Added new animal successfully using quick add.");
                	
            	}
            	else {
            		System.out.println("You have to add atleast one animal first to use quick add");
            	}
            	
            	break;
            	
            case 4:
            	viewAnimal();
                
                animalIndex = 0;
                System.out.print("Choose an animal to modify: ");
                animalIndex = scan.nextInt();
                scan.nextLine();
                
                int strategyChoice = 0;
                System.out.println("=== Change Animal Strategy ===");
                System.out.println("1. Change Movement Strategy");
                System.out.println("2. Change Sound Strategy");
                System.out.print("Choose an option: ");
                strategyChoice = scan.nextInt();
                scan.nextLine();
                
//                AbstractAnimal selectedAnimal = animals.get(animalIndex - 1);
                selectedAnimal = db.getAnimals().get(animalIndex - 1);
               
                if (strategyChoice == 1) {
                    System.out.println("1. Walk");
                    System.out.println("2. Hop");
                    System.out.print("Choose movement strategy: ");
                    int moveStrategy3 = scan.nextInt();
                    scan.nextLine();

                    if (moveStrategy3 == 1) selectedAnimal.setMovementStrategy(new WalkStrategy());
                    else if (moveStrategy3 == 2) selectedAnimal.setMovementStrategy(new HopStrategy());
                    
                } else if (strategyChoice == 2) {
                    System.out.println("1. Roar");
                    System.out.println("2. Squeal");
                    System.out.print("Choose sound strategy: ");
                    int soundStrategy3 = scan.nextInt();
                    scan.nextLine();

                    if (soundStrategy3 == 1) selectedAnimal.setSoundStrategy(new RoarStrategy());
                    else if (soundStrategy3 == 2) selectedAnimal.setSoundStrategy(new SquealStrategy());
                   
                }

                System.out.println("Strategy updated successfully.");
                
            	break;
            case 5:
            	String enclosureName = "";
            	System.out.println("Enter Enclosure's Name: ");
            	enclosureName = scan.nextLine();
            	
            	int facility = 0;
            	System.out.println("Choose Enclosure's Facilities:");
            	System.out.println("1. Humidity and temperature control");
            	System.out.println("2. Water filtration");
            	System.out.println("3. All");
            	facility = scan.nextInt(); scan.nextLine();
            	
            	Enclosure basicEnclosure = new BasicEnclosure(enclosureName);
            	Enclosure newEnclosure = null;
            	switch(facility) {
            	case 1:
            		newEnclosure = new TropicalEnclosure(basicEnclosure);
            		break;
            	case 2:
            		newEnclosure = new AquaticEnclosure(basicEnclosure);
            		break;
            	case 3:
            		newEnclosure = new TropicalEnclosure(new AquaticEnclosure(basicEnclosure));
            		break;
            	}
            	
            	newEnclosure.specification();
            	enclosures.add(newEnclosure);
            	System.out.println("Successfully added new enclosure.");
            	break;
            case 6:
            	for(Enclosure e : enclosures) {
            		e.specification();
            		 System.out.println("------------------------");
            	}
            	break;
            case 7:
            	viewObserver();
            	break;
            case 8:
            	addObserver();
            	break;
            case 9:
            	notifyObserver();
            	break;
           
            case 10:
            	viewAnimal();
            	
            	if(db.checkDB() != 0) {
            		System.out.print("Choose an animal to feed: ");
                    animalIndex = scan.nextInt();
                    scan.nextLine();
                    
                    selectedAnimal = db.getAnimals().get(animalIndex - 1);
                    if(selectedAnimal instanceof LargeAnimal) {
                    	LargeAnimalFeedingRoutine largeAnimalFeedingRoutine = new LargeAnimalFeedingRoutine();
                    	largeAnimalFeedingRoutine.executeFeedingRoutine();
                    	
                    }
                    else {
                    	SmallAnimalFeedingRoutine smallAnimalFeedingRoutine = new SmallAnimalFeedingRoutine();
                    	smallAnimalFeedingRoutine.executeFeedingRoutine();
                    }
            	}
            	else {
            		System.out.println("Can't do feeding routine.");
            	}
                
                
            	break;
            case 11:
            	List<AbstractAnimal> allAnimals = db.getAnimals();

            	// Memfilter LargeAnimal
            	List<LargeAnimal> largeAnimals = allAnimals.stream()
            	    .filter(animal -> animal instanceof LargeAnimal) // Memastikan hanya LargeAnimal
            	    .map(animal -> (LargeAnimal) animal)             // Konversi ke LargeAnimal
            	    .collect(Collectors.toList());
            	
            	// Memfilter SmallAnimal
            	List<SmallAnimal> smallAnimals = allAnimals.stream()
            	    .filter(animal -> animal instanceof SmallAnimal) // Memastikan hanya SmallAnimal
            	    .map(animal -> (SmallAnimal) animal)             // Konversi ke SmallAnimal
            	    .collect(Collectors.toList());
            	
                Keeper<LargeAnimal> largeAnimalKeeper = new Keeper<>(largeAnimals);
                Keeper<SmallAnimal> smallAnimalKeeper = new Keeper<>(smallAnimals);
      
                List<Keeper<? extends Animal>> keepers = Arrays.asList(largeAnimalKeeper, smallAnimalKeeper);          

                // Gunakan ZooFacade
                ZooFacade zooFacade = new ZooFacade();

                // Jadwalkan perawatan harian
                System.out.println("Starting daily care schedule...");
                zooFacade.scheduleDailyCare(keepers);
                
//                System.out.println("\nVerifying all animal states:");
//                allAnimals.forEach(animal -> {
//                    System.out.println(animal.getName() + " is in state: " + ((AbstractAnimal) animal).getState().getClass().getSimpleName());
//                });
                
//                System.out.println("\nChanging all animal states to HappyState using Command...");
                Command changeStateToHappy = new ChangeStateCommand(allAnimals, new HappyState());
                CommandInvoker invoker = new CommandInvoker();
                invoker.executeCommand(changeStateToHappy);
                

                // Verifikasi perubahan state
                System.out.println("\nVerifying all animal states:");
                allAnimals.forEach(animal -> {
                    System.out.println(animal.getName() + " is in state: " + ((AbstractAnimal) animal).getState().getClass().getSimpleName());
                });
                
                System.out.println("\nDaily care schedule completed.");
            	break;
            case 12:         	
            	System.out.println("Checking all animal states");
            	db.getAnimals().forEach(animal -> {
                    String state = animal.getState() != null ? animal.getState().getClass().getSimpleName() : "Unknown";
                    System.out.println("Animal: " + animal.getName() + ", State: " + state);
                });
            	break;
            case 13:
            	System.out.println("Exiting the Zoo Management System. Goodbye!");
                scan.close();
            	break;
            }
        } while (chooseMenu!=13);
	}
	
    public static void main(String[] args) {
        new App();
    }
    
    private void viewAnimal() {
    	if(db.checkDB() == 0) {
			System.out.println("No Animals.");
		}
		else {
			db.viewAll();
		}
    }
    
    private void addObserver() {
		System.out.print("Visitor Name: ");
		String visitorName = scan.nextLine();
		
		System.out.print("Visitor Type [Normal(1) | VIP(2)]: ");
		int visitorType = scan.nextInt();
		scan.nextLine();
		
		PromoObserver visitor = null;
		if(visitorType == 1) {
			visitor = new NormalVisitor(visitorName);
		}
		else if (visitorType == 2) {
			visitor = new VIPVisitor(visitorName);
		}
		
		zoo.addObserver(visitor);
		System.out.println("Success");
		scan.nextLine();
	}
	
	private void notifyObserver() {
		if(zoo.hasVisitor()) {
			System.out.println("Visitor list is empty");
		}
		else {
			System.out.print("Promo Title: ");
			String promoTitle = scan.nextLine();
			
			System.out.println("Promo Content: ");
			String promoContent = scan.nextLine();
			
			Promo newPromo = new Promo(promoTitle, promoContent);
			
			System.out.print("Visitor Type [All(0) | Normal(1) | VIP(2)]: ");
			int customerType = scan.nextInt();
			scan.nextLine();
			
			zoo.notifyObserver(newPromo, customerType);
			
			System.out.println("Success");
			scan.nextLine();
		}
	}
	
	private void viewObserver() {
		zoo.viewObserver();
		System.out.println("Press Enter to Continue");
		scan.nextLine();
	}
}
