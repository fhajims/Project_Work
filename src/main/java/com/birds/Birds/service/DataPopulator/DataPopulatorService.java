package com.birds.Birds.service.DataPopulator;

import com.birds.Birds.model.*;
import com.birds.Birds.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DataPopulatorService {

    private final ConservationStatusRepository conservationStatusRepository;
    private final ImageRepository imageRepository;
    private final ObservationRepository observationRepository;
    private final BirdRepository birdRepository;

    private final RaptorRepository raptorRepository;

    private final SongbirdRepository songbirdRepository;



    @PostConstruct
    public void populateDatabase() {
        if (conservationStatusRepository.count() > 0) {
            return;
        }



        ConservationStatus[] statuses = {
                new ConservationStatus(null, "Critically Endangered", "California Condor", "One of the world's rarest birds", "A1a", 2024, "Increasing", "Southwestern United States"),
                new ConservationStatus(null, "Endangered", "Kakapo", "Flightless parrot from New Zealand", "B2b", 2024, "Increasing", "New Zealand"),
                new ConservationStatus(null, "Vulnerable", "Harpy Eagle", "Powerful raptor of tropical rainforests", "C3c", 2024, "Decreasing", "Central and South America"),
                new ConservationStatus(null, "Near Threatened", "Bald Eagle", "National bird of the United States", "D4d", 2024, "Stable", "North America"),
                new ConservationStatus(null, "Least Concern", "American Robin", "Common bird across North America", "E5e", 2024, "Stable", "North America"),
                new ConservationStatus(null, "Critically Endangered", "Spix's Macaw", "Known from a single individual in the wild", "F6f", 2024, "Increasing", "Brazil"),
                new ConservationStatus(null, "Endangered", "Philippine Eagle", "Largest living eagle by length", "G7g", 2024, "Decreasing", "Philippines"),
                new ConservationStatus(null, "Vulnerable", "Great Indian Bustard", "Large, terrestrial bird of the Indian subcontinent", "H8h", 2024, "Decreasing", "India"),
                new ConservationStatus(null, "Near Threatened", "African Grey Parrot", "Highly intelligent and known for its mimicry", "I9i", 2024, "Decreasing", "Central Africa"),
                new ConservationStatus(null, "Least Concern", "Peregrine Falcon", "Fastest bird of prey", "J0j", 2024, "Stable", "Worldwide"),
                new ConservationStatus(null, "Critically Endangered", "Javan Hawk-Eagle", "Rare raptor found only in Java", "K1k", 2024, "Decreasing", "Java"),
                new ConservationStatus(null, "Endangered", "Yellow-eyed Penguin", "One of the rarest and least known penguins", "L2l", 2024, "Decreasing", "New Zealand"),
                new ConservationStatus(null, "Vulnerable", "Wilson's Bird-of-Paradise", "Distinctive bird with elaborate plumage", "M3m", 2024, "Decreasing", "Indonesia"),
                new ConservationStatus(null, "Near Threatened", "Cuban Parrot", "Small parrot native to Cuba", "N4n", 2024, "Stable", "Cuba"),
                new ConservationStatus(null, "Least Concern", "House Sparrow", "Common bird in urban areas worldwide", "O5o", 2024, "Stable", "Worldwide"),
                new ConservationStatus(null, "Critically Endangered", "Imperial Amazon", "One of the rarest parrots in the world", "P6p", 2024, "Decreasing", "Puerto Rico"),
                new ConservationStatus(null, "Endangered", "Spoon-billed Sandpiper", "Small wader with distinctive spoon-shaped bill", "Q7q", 2024, "Decreasing", "East Asia"),
                new ConservationStatus(null, "Vulnerable", "Laysan Albatross", "Known for its long-distance flying capabilities", "R8r", 2024, "Decreasing", "Pacific Ocean"),
                new ConservationStatus(null, "Near Threatened", "Northern Bald Ibis", "Distinctive bald-headed ibis found in parts of Europe", "S9s", 2024, "Stable", "Europe, North Africa"),
                new ConservationStatus(null, "Least Concern", "Common Starling", "Highly adaptable bird found in many regions", "T0t", 2024, "Stable", "Europe, Asia, North America"),
                new ConservationStatus(null, "Critically Endangered", "Spoon-billed Sandpiper", "Small wader with distinctive spoon-shaped bill", "U1u", 2024, "Decreasing", "East Asia")
        };







        Bird[] birds = {

                new Bird(null, "Kakapo", "Green with yellow and brown", true, 0.75, 0.15, "New Zealand forests", "Fruits and nuts", 90, "Non-migratory", "http://localhost:8081/images/kakapo.jpg", "9T1vfsHYiKY", "Parrot", new HashSet<>(), statuses[1]),
                new Bird(null, "American Robin", "Red breast with grayish-brown wings", false, 0.25, 0.05, "North American gardens and forests", "Insects and fruits", 2, "Migratory", "http://localhost:8081/images/robin.png", "NMkQbi2eZa0", "Songbird", new HashSet<>(), statuses[4]),
                new Bird(null, "Common Raven", "Black with iridescent sheen", false, 1.3, 0.7, "Various habitats across the Northern Hemisphere", "Omnivorous", 20, "Resident", "http://localhost:8081/images/kolkrabe.png", "L65Q5LTDhZQ", "Corvid", new HashSet<>(), statuses[5]),
                new Bird(null, "Eurasian Bullfinch", "Bright red breast and cheeks, black cap, gray back", false, 0.18, 0.03, "European and Asian woodlands and gardens", "Seeds and buds", 4, "Resident", "http://localhost:8081/images/eurasianbullfinch.jpg", "Of6iALKAFbw" +
                        "", "Songbird", new HashSet<>(), statuses[4]),
                new Bird(null, "Wagtail", "Black and white with long tail", false, 0.25, 0.02, "Open country, often near water", "Insects", 3, "Resident", "http://localhost:8081/images/wagtail.jpg", "XD8i2fSgPug", "Songbird", new HashSet<>(), statuses[4])

        };


        Image[] images = {
                new Image(null, "california_condor_1.jpg", "http://localhost:8081/images/infantry_section.png", birds[0]),
                new Image(null, "california_condor_2.jpg", "/images/california_condor_2.jpg", birds[0]),
                new Image(null, "kakapo_1.jpg", "/images/kakapo_1.jpg", birds[1]),
                new Image(null, "harpy_eagle_1.jpg", "/images/harpy_eagle_1.jpg", birds[2]),
                new Image(null, "bald_eagle_1.jpg", "/images/bald_eagle_1.jpg", birds[3]),
                new Image(null, "american_robin_1.jpg", "/images/american_robin_1.jpg", birds[4]),
                new Image(null, "american_robin_2.jpg", "/images/american_robin_2.jpg", birds[4])
        };

        Observation[] observations = {

                new Observation(null, LocalDateTime.of(2024, 8, 1, 10, 30), "California, USA", "Seen near the Grand Canyon. First sighting in the area in decades.", birds[0]),
                new Observation(null, LocalDateTime.of(2024, 8, 2, 11, 0), "New Zealand", "Observed in the forest reserve during a conservation survey.", birds[1]),
                new Observation(null, LocalDateTime.of(2024, 8, 3, 14, 15), "Amazon Rainforest", "Harpy Eagle spotted hunting in the dense canopy.", birds[2]),
                new Observation(null, LocalDateTime.of(2024, 8, 4, 9, 45), "Florida, USA", "Bald Eagle observed nesting near a river.", birds[3]),
                new Observation(null, LocalDateTime.of(2024, 8, 5, 16, 30), "New York, USA", "American Robin observed feeding in a city park.", birds[4])

        };

        Raptor[] raptors = {
                new Raptor(null, "California Condor", "Black with white patches", false, 2.9, 0.3, "California Condor habitat", "Carrion", 60, "Resident", "http://localhost:8081/images/californiacondor.png", "Omkpr7n1jCU", "Raptor", new HashSet<>(), statuses[0], 12.0, "Cliffs", "Soaring"),
                new Raptor(null, "Harpy Eagle", "Dark brown with white head", false, 2.0, 0.25, "Tropical rainforests", "Medium-sized mammals and birds", 35, "Resident", "http://localhost:8081/images/harpyeagle.jpg", "fS1TfANV0WA", "Raptor", new HashSet<>(), statuses[2], 15.0, "Trees", "Active"),
                new Raptor(null, "Bald Eagle", "Dark brown with white head and tail", false, 2.3, 0.25, "North American lakes and rivers", "Fish", 20, "Migratory", "http://localhost:8081/images/baldeagle.jpg", "hecXupPpE9o", "Raptor", new HashSet<>(), statuses[3], 10.0, "Nests", "Soaring")
        };

        Songbird[] songbirds = {
                new Songbird(null, "American Robin", "Red breast with grayish-brown wings", false, 0.25, 0.05, "North American gardens and forests", "Insects and fruits", 2, "Migratory", "http://localhost:8081/images/robin.png", "NMkQbi2eZa0", "Songbird", new HashSet<>(), statuses[4], "Melodious", "Non-territorial", "Cup-shaped"),
                new Songbird(null, "Eurasian Bullfinch", "Bright red breast and cheeks, black cap, gray back", false, 0.18, 0.03, "European and Asian woodlands and gardens", "Seeds and buds", 4, "Resident", "http://localhost:8081/images/eurasianbullfinch.jpg", "Of6iALKAFbw", "Songbird", new HashSet<>(), statuses[2], "Sweet", "Territorial", "Cup-shaped"),
                new Songbird(null, "Wagtail", "Black and white with long tail", false, 0.25, 0.02, "Open country, often near water", "Insects", 3, "Resident", "http://localhost:8081/images/wagtail.jpg", "XD8i2fSgPug", "Songbird", new HashSet<>(), statuses[1], "Chirpy", "Territorial", "Open")
        };




        for (ConservationStatus status : statuses) {
            conservationStatusRepository.save(status);
        }

        for (Songbird songbird : songbirds) {
            songbirdRepository.save(songbird);
        }


        for (Raptor raptor : raptors) {
            raptorRepository.save(raptor);
        }


        for (Bird bird : birds) {
            birdRepository.save(bird);

        }

        for (Image image : images) {
            imageRepository.save(image);
        }

        for (Observation observation : observations) {
            observationRepository.save(observation);
        }



    }
}
