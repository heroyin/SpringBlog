package com.raysmond.blog;

import com.raysmond.blog.models.Post;
import com.raysmond.blog.models.Tag;
import com.raysmond.blog.models.User;
import com.raysmond.blog.repositories.PostRepository;
import com.raysmond.blog.repositories.TagRepository;
import com.raysmond.blog.repositories.UserRepository;
import com.raysmond.blog.utils.DTOUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTest {

	@Autowired
	PostRepository postRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TagRepository tagRepository;

	@Test
	public void createPost() throws Exception {


		User user = userRepository.findByEmail("admin");
		Tag tag = tagRepository.save(new Tag("test"));
		Set<Tag> tags = new HashSet<>();
		tags.add(tag);

        Post post = new Post();
        post.setUser(user);
        post.setTags(tags);
        post.setTitle("title");
        post.setRenderedContent("content");
        post.setRenderedSummary("summary");

        postRepository.save(post);

        ///重新生成对象，因为post在保存后已经生成了id了
        post = new Post();
        post.setUser(user);
        post.setTags(tags);
        post.setTitle("title");
        post.setRenderedContent("content");
        post.setRenderedSummary("summary");
        postRepository.save(post);

        Page<Post> posts = postRepository.findByTag("test", new PageRequest(0, 10, Sort.Direction.DESC, "createdAt"));

        Assert.assertEquals(posts.getContent().size(), 2);


	}

}
