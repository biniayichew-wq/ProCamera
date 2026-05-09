package com.example.procamera

import jp.co.cyberagent.android.gpuimage.*

object FilterManager {

    data class FilterOption(val name: String, val filter: GPUImageFilter)

    val filters: List<FilterOption> = listOf(
        FilterOption("iPhone 17 - Rich Contrast", createRichContrast()),
        FilterOption("iPhone 17 - Vibrant", createVibrant()),
        FilterOption("iPhone 17 - Warm", createWarm()),
        FilterOption("iPhone 17 - Cool", createCool()),
        FilterOption("iPhone 17 - Standard Enhanced", createStandardEnhanced()),
        FilterOption("S25 Ultra - Scene Optimizer", createSceneOptimizer()),
        FilterOption("S25 Ultra - Detail Enhancer", createDetailEnhancer()),
        FilterOption("S25 Ultra - Bright Night", createBrightNight()),
        FilterOption("S25 Ultra - Pro Color", createProColor()),
        FilterOption("S25 Ultra - HDR+", createHDRPlus())
    )

    private fun createRichContrast(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageContrastFilter(1.25f))
        group.addFilter(GPUImageHighlightShadowFilter().apply {
            setShadows(0.2f)
            setHighlights(0.1f)
        })
        group.addFilter(GPUImageSharpenFilter(0.3f))
        return group
    }

    private fun createVibrant(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageSaturationFilter(1.3f))
        group.addFilter(GPUImageContrastFilter(1.1f))
        group.addFilter(GPUImageRGBFilter().apply {
            setRed(1.05f); setGreen(1.05f); setBlue(1.05f)
        })
        return group
    }

    private fun createWarm(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageWhiteBalanceFilter().apply {
            setTemperature(4500f)
            setTint(0f)
        })
        group.addFilter(GPUImageRGBFilter().apply {
            setRed(1.1f); setGreen(1.0f); setBlue(0.9f)
        })
        return group
    }

    private fun createCool(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageWhiteBalanceFilter().apply {
            setTemperature(7000f)
            setTint(0f)
        })
        group.addFilter(GPUImageRGBFilter().apply {
            setRed(1.0f); setGreen(1.05f); setBlue(1.1f)
        })
        return group
    }

    private fun createStandardEnhanced(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageExposureFilter(0.1f))
        group.addFilter(GPUImageSharpenFilter(0.2f))
        group.addFilter(GPUImageBrightnessFilter(0.05f))
        return group
    }

    private fun createSceneOptimizer(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageBrightnessFilter(0.05f))
        group.addFilter(GPUImageContrastFilter(1.15f))
        group.addFilter(GPUImageSaturationFilter(1.1f))
        group.addFilter(GPUImageSharpenFilter(0.4f))
        group.addFilter(GPUImageExposureFilter(0.1f))
        return group
    }

    private fun createDetailEnhancer(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageSharpenFilter(0.7f))
        return group
    }

    private fun createBrightNight(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageHighlightShadowFilter().apply {
            setShadows(0.6f)
            setHighlights(0.1f)
        })
        group.addFilter(GPUImageBrightnessFilter(0.15f))
        group.addFilter(GPUImageSaturationFilter(1.2f))
        return group
    }

    private fun createProColor(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageSaturationFilter(1.2f))
        group.addFilter(GPUImageContrastFilter(1.2f))
        group.addFilter(GPUImageRGBFilter().apply {
            setRed(1.05f); setGreen(1.02f); setBlue(1.0f)
        })
        group.addFilter(GPUImageSharpenFilter(0.2f))
        return group
    }

    private fun createHDRPlus(): GPUImageFilterGroup {
        val group = GPUImageFilterGroup()
        group.addFilter(GPUImageHighlightShadowFilter().apply {
            setShadows(0.3f)
            setHighlights(0.3f)
        })
        group.addFilter(GPUImageContrastFilter(1.1f))
        group.addFilter(GPUImageSaturationFilter(1.05f))
        return group
    }
}
