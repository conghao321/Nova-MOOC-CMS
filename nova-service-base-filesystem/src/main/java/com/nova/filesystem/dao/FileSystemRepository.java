package com.nova.filesystem.dao;

import com.nova.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Hao cong
 * @date Aug2020
 */
public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}
