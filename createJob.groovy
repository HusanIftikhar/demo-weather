pipelineJob('pipelineJob'){
    defination{
        cps{
            script(readFileFromWorkSace('pipelineJob.groovy'))
            sandbox()
        }
    }
}