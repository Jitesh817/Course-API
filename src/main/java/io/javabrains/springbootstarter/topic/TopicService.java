package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<Topic>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    Topic getTopic(String id) {
        return topicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    void updateTopic(String id, Topic topic) { topicRepository.save(topic);}

    void deleteTopic(String id) {
        topicRepository.deleteById(id);
    }
}
