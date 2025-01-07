package com.ll.jpa2501.domain.post;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }

    public List<Post> findByUsername(String username) {
        postRepository.findById(1L);
        postRepository.findByUsername(username);
        return postRepository.findByUsername(username);
    }

    @SneakyThrows
    public Optional<Post> findWithShareLockById(Long id) {
        postRepository.findWithShareLockById(id);
        Thread.sleep(10000);
        return postRepository.findWithShareLockById(id);
    }

    public Post create(String username, String subject, String content) {
        return postRepository.save(Post.builder()
                .username(username)
                .subject(subject)
                .content(content)
                .build());
    }
}
