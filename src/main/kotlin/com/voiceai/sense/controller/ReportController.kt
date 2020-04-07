package com.voiceai.sense.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.elasticsearch.core.ReactiveElasticsearchTemplate
import org.springframework.web.bind.annotation.RestController

@RestController
class ReportController {
    @Autowired
    lateinit var template: ReactiveElasticsearchTemplate

    //屎都卡出来了,换电脑了再搞kotlin
/*
    fun insertReport(): Flux<String> {
        template.delete()

    }
*/

}