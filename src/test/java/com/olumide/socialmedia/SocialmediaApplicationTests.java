package com.olumide.socialmedia;

import com.olumide.socialmedia.models.Post;
import com.olumide.socialmedia.models.User;
import com.olumide.socialmedia.repo.PostRepository;
import com.olumide.socialmedia.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class SocialmediaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private PostRepository postRepository;

	@InjectMocks
	private PostService postService;

	@Test
	public void testCreatePost() {
		Post mockPost = new Post();


		Post createdPost = postService.createPost(mockPost);
		assertEquals("Hello, world!", createdPost.getContent());
		assertEquals(0, createdPost.getLikesCount());
		assertNotNull(createdPost.getCreationDate());
		assertNotNull(createdPost.getUser());
	}

}
